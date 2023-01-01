package io.github.charmicat.vaghelper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.speech.tts.TextToSpeech;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.android.controller.ServiceController;

@RunWith(AndroidJUnit4.class)
public class HelperFunctionsTest{
    private Context testContext;

    private Resources testResources;

    @Before
    public void setUp() {
        testContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        testResources = testContext.getResources();
    }

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
//        InputStream chime = testResources.openRawResource(R.raw.casio);
        assertTrue(HelperFunctions.playAudio(testContext, R.raw.casiochime));
    }
}