package com.multi.hereevent.event.time;

import com.multi.hereevent.dto.EventTimeDTO;

import java.util.List;

public interface EventTimeService {
    int insertEventTimeList(List<EventTimeDTO> eventTimeList);
}
