package com.github.dreamhead.moco.handler.failover;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.common.base.Objects;

import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Request extends Message {
    private Map<String, String> queries;
    private String method;

    public void addQuery(String key, String value) {
        this.queries.put(key, value);
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Message)) {
            return false;
        }


        Request that = (Request) obj;
        return super.equals(that) && Objects.equal(method, that.method)
                && Objects.equal(queries, that.queries);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), queries, method);
    }
}
