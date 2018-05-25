package net.afalko.zipkin.filter;

import org.springframework.stereotype.Component;
import zipkin.Span;
import zipkin.filter.FilterActivatedException;
import zipkin.filter.SpanFilter;
import zipkin.storage.Callback;

import java.util.Collections;
import java.util.List;

@Component
public class ExampleSpanFilter implements SpanFilter<Span> {
    public List<Span> process(List<Span> spans, Callback<Void> callback) {
        // Just blocks everything
        callback.onError(new FilterActivatedException("All spans blocked by design", 429));
        return Collections.emptyList();
    }
}
