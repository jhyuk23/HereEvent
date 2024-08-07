package com.multi.hereevent.event.time;

import com.multi.hereevent.dto.EventTimeDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class EventTimeDAOImpl implements EventTimeDAO {
    private final SqlSession sqlSession;

    @Override
    public int insertEventTimeList(List<EventTimeDTO> eventTimeList) {
        return sqlSession.insert("com.multi.hereevent.event.time.insertEventTimeList", eventTimeList);
    }

    @Override
    public int updateEventTimeList(List<EventTimeDTO> eventTimeList) {
        return sqlSession.update("com.multi.hereevent.event.time.updateEventTimeList",eventTimeList);
    }

    @Override
    public EventTimeDTO getEventTimeByEventNoAndDay(int event_no, String day) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("event_no",event_no);
        param.put("day",day);
        return sqlSession.selectOne("com.multi.hereevent.event.time.getEventTimeByEventNoAndDay", param);
    }

    @Override
    public List<EventTimeDTO> getEventTime(int event_no) {
        return sqlSession.selectList("com.multi.hereevent.event.time.getEventTime", event_no);
    }

    @Override
    public List<String> getHolidayDays(int event_no) {
        return sqlSession.selectList("com.multi.hereevent.event.time.getHolidayDays", event_no);

    }

}
