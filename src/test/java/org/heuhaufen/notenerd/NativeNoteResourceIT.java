package org.heuhaufen.notenerd;

import org.junit.jupiter.api.Disabled;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
@Disabled
public class NativeNoteResourceIT extends NoteResourceTest {

    // Execute the same tests but in native mode.
}