package HKUST;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Evegen on 18.11.2016.
 * Step 1: Create an instance of SimpleStereoCreator. A canvas will show up.
 * Step 2: Run the "createStereo()" method.
 * Step 3: An open file dialog pops up, load the left image from this dialog.
 * Step 4: Another open file dialog pops up, load the right image from this dialog.
 * Step 5: The stereo image is then shown on the canvas.
 *
 * path to images \src\main\resources\Image pairs
 */
public class SimpleStereoCreatorTest {

    public static void main(String[] args) {
        new SimpleStereoCreator().createStereo();
    }

}