package ru.ignatown.my_pastebin.entity;

import java.util.Objects;

public class PasteDTO {
    private String text;
    private long expirationTime;
    private String publicType;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getPublicType() {
        return publicType;
    }

    public void setPublicType(String publicType) {
        this.publicType = publicType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PasteDTO pasteDTO = (PasteDTO) o;
        return expirationTime == pasteDTO.expirationTime && Objects.equals(text, pasteDTO.text) && Objects.equals(publicType, pasteDTO.publicType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, expirationTime, publicType);
    }
}
