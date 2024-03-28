package com.VersatileDataProcessor.ElasticsearchWriter.repositories;

import com.VersatileDataProcessor.ElasticsearchWriter.models.MessageType;
import com.VersatileDataProcessor.ElasticsearchWriter.models.processedMessages.MessageInterface;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.annotations.Query;

public interface MessageRepository extends ElasticsearchRepository<MessageInterface, String> {
}
