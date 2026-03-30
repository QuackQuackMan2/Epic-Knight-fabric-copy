package com.magistuarmory.util;

import org.junit.Test;

public class DiagnosticDumperTest {

    @Test
    public void testDumpingDiagnosticsDoesNotThrow() {
        DiagnosticDumper.dump("Test diagnostic", new RuntimeException("test"));
    }
}
