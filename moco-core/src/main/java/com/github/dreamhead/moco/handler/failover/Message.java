package com.github.dreamhead.moco.handler.failover;

import com.google.common.base.Objects;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class Message {
    private String version;
    private String content;
    private Map<String, String> headers = newHashMap();

    public void setVersion(String version) {
        this.version = version;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public String getVersion() {
        return version;
    }

    public String getContent() {
        return content;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Message)) {
            return false;
        }

        Message that = (Message) obj;
        return Objects.equal(version, that.version)
                && Objects.equal(content, that.content)
                && Objects.equal(headers, that.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(version, content, headers);
    }
}
