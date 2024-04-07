package com.springboot;

import com.springboot.entity.WikimediaData;
import com.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger log= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository repository;

    public KafkaDatabaseConsumer(WikimediaDataRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "wikimedia_recentchnage",groupId = "myGroup")
    public void consumer(String eventMessage){
        log.info(String.format("message received %s",eventMessage));

        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        repository.save(wikimediaData);

    }
}
