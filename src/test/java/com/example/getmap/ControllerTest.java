package com.example.getmap;

import com.example.getmap.controller.DemoController;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    @Test
    public void testController() throws Exception {
        DemoController demoController = new DemoController();
        boolean result = demoController.sign("Test");
        assert(result);
    }
}
