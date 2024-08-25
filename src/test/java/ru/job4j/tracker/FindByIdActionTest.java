package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {
    @Test
    public void whenItemFoundById() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        int itemId = 1;
        Item item = new Item(itemId, "Found item");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(itemId);
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + item + ln
        );
    }
}