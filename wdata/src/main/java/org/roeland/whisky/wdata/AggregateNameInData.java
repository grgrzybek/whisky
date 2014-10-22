package org.roeland.whisky.wdata;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.roeland.whisky.wdata.remote.WhiskyName;

public class AggregateNameInData implements AggregationStrategy {

    public Exchange aggregate(Exchange original, Exchange resource) {
        BottleReply originalBody = original.getIn().getBody(BottleReply.class);
        WhiskyName resourceBody = resource.getIn().getBody(WhiskyName.class);

        originalBody.setName(resourceBody.getName());

        if (original.getPattern().isOutCapable()) {
            original.getOut().setBody(originalBody);
            original.getOut().setHeaders(original.getIn().getHeaders());
        } else {
            original.getIn().setBody(originalBody);
            original.getIn().setHeaders(original.getIn().getHeaders());
        }
        return original;
    }

}