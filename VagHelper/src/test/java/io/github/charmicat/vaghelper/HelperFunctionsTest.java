package io.github.charmicat.vaghelper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static io.github.charmicat.vaghelper.R;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.speech.tts.TextToSpeech;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;

@RunWith(MockitoJUnitRunner.class)
public class HelperFunctionsTest{
    //@Mock
    private Context testContext;

    private Resources testResources;

    @Before
    public void setUp() {
        testContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        testResources = testContext.getResources();
    }

//    @After
//    public void tearDown() {
//    }

    @Test
    public void isServiceRunning() {
        assertTrue(HelperFunctions.isServiceRunning(testContext, "com.vag.mychime.service.TimeService", true));
    }

    @Test
    public void isIntentAvailable() {
        assertTrue(HelperFunctions.isIntentAvailable(testContext, TextToSpeech.Engine.ACTION_CHECK_TTS_DATA, true));
    }

    @Test
    public void rateApp() {
        Intent intent = HelperFunctions.rateApp(testContext, true);
        assertNotNull(intent);
    }

    @Test
    public void playAudio() {
        assertNotNull(testResources);
        InputStream chime = testResources.openRawResource(R.raw.casio);
        assertTrue(HelperFunctions.playAudio(testContext, R.raw.casio));
    }
}