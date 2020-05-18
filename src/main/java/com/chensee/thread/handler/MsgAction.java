package com.chensee.thread.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MsgAction {

    private String userKey;
    private String destination;
    private int opr;

}