package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {
    @Test
    public void whenItemsFoundByName() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        String itemName = "Test item";
        Item item1 = new Item(itemName);
        Item item2 = new Item(itemName);
        tracker.add(item1);
        tracker.add(item2);
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(itemName);
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by name ===" + ln
                        + item1 + ln
                        + item2 + ln
        );
    }
}