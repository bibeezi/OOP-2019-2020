package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import ddf.minim.ugens.Oscil;
import ddf.minim.ugens.Waves;
import processing.core.PApplet;

public class SoundSynthesis extends PApplet
{
    private float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
        , 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f, 1318.51f, 1479.98f, 1567.98f, 1760.00f, 1975.53f, 2217.46f, 2349.32f};
    Minim minim;
    AudioOutput out;
    Oscil wave;
    Oscil wave2;

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        minim = new Minim(this);

        out = minim.getLineOut();
        wave = new Oscil( 440, 0.5f, Waves.SINE );
        wave.patch(out);
    }

    public void keyPressed() {
        if (key == ' ')
        {
            wave.setFrequency(wave.frequency.getLastValue() + 100);
        }
    }

    float offset = 0;

    public void draw()
    {
        //wave.setFrequency(random(60, 2000));
        float n = noise(offset);
        wave.setFrequency(
            frequencies[(int) map(n, 0, 1, 0, frequencies.length)];
        );

        offset += 0.01f;

        float cx = width / 2;
        float cy = height / 2;

        background(0);
        stroke(255);
        noFill();
        ellipse(cx, cy, 300, 300);
        ellipse(cx, cy, 20, 20);
        ellipse(cx - 100, cy - 50, 20, 20);
        ellipse(cx + 100, cy - 50, 20, 20);

        ellipse(cx, cy + 100, 100,
            map(n, 0, 1, 0, 60)
        );
    }
}