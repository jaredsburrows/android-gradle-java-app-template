package burrows.apps.example.template.instrumentation;

import android.test.ActivityInstrumentationTestCase2;

import burrows.apps.example.template.activity.MainActivity;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class burrows.apps.example.template.instrumentation.MainActivityTest \
 * burrows.apps.example.template.tests/android.test.InstrumentationTestRunner
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }
}
