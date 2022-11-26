package com.miu.Service.Impl;


import com.miu.Entity.TVSeries;
import com.miu.Enum.FilterType;
import com.miu.Repository.ActorSeriesRepo;
import com.miu.Repository.TVSeriesRepo;
import com.miu.Service.TVSeriesService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class TVSeriesServiceImpl implements TVSeriesService {

    private final ActorSeriesRepo actorSeriesRepo;
    private final RabbitTemplate rabbitTemplate;
    private final Queue deleteSeries;
    final TVSeriesRepo tvSeriesRepo;
    public TVSeriesServiceImpl(RabbitTemplate rabbitTemplate, Queue deleteSeries, TVSeriesRepo tvSeriesRepo, ActorSeriesRepo actorSeriesRepo) {
        this.rabbitTemplate = rabbitTemplate;
        this.deleteSeries = deleteSeries;
        this.tvSeriesRepo = tvSeriesRepo;
        this.actorSeriesRepo = actorSeriesRepo;
    }

    @Override
    public TVSeries findById(Long seriesId) {
        return tvSeriesRepo.findTVSeriesById(seriesId);
    }

    @Override
    public void deleteById(Long seriesId) {
        rabbitTemplate.convertAndSend("deleteSeries",seriesId);
        tvSeriesRepo.deleteById(seriesId);
    }
    @Override
    public void Update(TVSeries series) {
        tvSeriesRepo.save(series);
    }

    @Override
    public void addTVSeries(TVSeries series) {
        tvSeriesRepo.save(series);
    }
    @Override
    public List<TVSeries> filterSeries(FilterType filterType, String value) {

        switch (filterType) {
            case GENRE:
                return tvSeriesRepo.findAllByGenre(value);
            case RELEASE_DATE:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                formatter = formatter.withLocale(Locale.US);
                LocalDate date = LocalDate.parse(value, formatter);
                return tvSeriesRepo.findAllByReleaseDate(date);
            case DIRECTOR:
                return tvSeriesRepo.findAllByDirector(value);
            case DURATION:
                return tvSeriesRepo.findAllByDurationInMinutes(Integer.parseInt(value));
            case ACTOR:
                return actorSeriesRepo.findAllByActor_FirstName(value)
                        .stream()
                        .map(x -> x.getSeries())
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }

    @Override
    public List<TVSeries> findAllSeries() {
        return tvSeriesRepo.findAll();
    }


}
