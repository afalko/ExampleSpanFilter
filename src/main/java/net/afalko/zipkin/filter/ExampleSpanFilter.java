package net.afalko.zipkin.filter;

import zipkin2.Callback;
import zipkin2.Span;
import zipkin2.collector.CollectorMetrics;
import zipkin2.collector.filter.SpanFilter;

import javax.xml.ws.http.HTTPException;
import java.util.Collections;
import java.util.List;

public class ExampleSpanFilter implements SpanFilter {
    public List block(Callback<Void> callback) {
        // Just blocks everything
        callback.onError(new HTTPException(429));
        return Collections.emptyList();
    }

    public List<Span> process(List<Span> list, CollectorMetrics metrics, Callback<Void> callback) {
        metrics.incrementSpansDropped(list.size());
        return block(callback);
    }
}
