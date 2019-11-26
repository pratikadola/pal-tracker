package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    long counter=1L;
    HashMap<Long, TimeEntry> repo = new HashMap();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(counter);
        repo.put(counter,timeEntry);
        counter++;
        return timeEntry;
        //return new TimeEntry(1L,any.getProjectId(),any.getUserId(),any.getDate(),any.getHours());
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return repo.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(repo.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(repo.get(id)!=null) {

            timeEntry.setId(id);
            repo.put(id, timeEntry);
        }
        return repo.get(id);
    }

    @Override
    public void delete(long timeEntryId) {

        repo.remove(timeEntryId);
    }

}
