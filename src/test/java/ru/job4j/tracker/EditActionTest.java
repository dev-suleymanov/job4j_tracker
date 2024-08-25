package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EditActionTest {

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Replaced item");
        tracker.add(item);
        int itemId = item.getId();
        String replacedName = "New item name";
        EditAction replaceAction = new EditAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(itemId);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        replaceAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Replace application: " + new Item(itemId, replacedName) + ln
        );
    }
}