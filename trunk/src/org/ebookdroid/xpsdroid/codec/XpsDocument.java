package org.ebookdroid.xpsdroid.codec;

import org.ebookdroid.core.codec.AbstractCodecDocument;
import org.ebookdroid.core.codec.CodecPage;

public class XpsDocument extends AbstractCodecDocument {

    private static final int FITZMEMORY = 512 * 1024;

    XpsDocument(final XpsContext context, final String fname) {
        super(context, open(FITZMEMORY, fname));
    }

    @Override
    public CodecPage getPage(final int pageNumber) {
        return XpsPage.createPage(documentHandle, pageNumber + 1);
    }

    @Override
    public int getPageCount() {
        return getPageCount(documentHandle);
    }

    @Override
    protected void freeDocument() {
        free(documentHandle);
    }

    private static native long open(int fitzmemory, String fname);

    private static native void free(long handle);

    private static native int getPageCount(long handle);

}
