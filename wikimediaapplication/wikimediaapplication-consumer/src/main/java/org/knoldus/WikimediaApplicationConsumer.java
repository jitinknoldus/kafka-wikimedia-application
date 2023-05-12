package org.knoldus;

import org.knoldus.entity.WikimediaData;
import org.knoldus.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaApplicationConsumer {

    private static final Logger logger = LoggerFactory.getLogger(WikimediaApplicationConsumer.class);

    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;



    @KafkaListener(
            topics="wikimedia_recentChange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        logger.info(String.format("Event message Received ->%s",eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        wikimediaDataRepository.save(wikimediaData);
    }

}
