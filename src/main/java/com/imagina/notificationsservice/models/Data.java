package com.imagina.notificationsservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {

    private Map<String, Object> templateData;
    private EmailData emailData;

    @Override
    public String toString() {
        return "Send email: " + emailData.getType() + " to: " + emailData.getTo();
    }
}
