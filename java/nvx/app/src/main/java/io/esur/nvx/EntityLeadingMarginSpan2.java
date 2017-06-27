package io.esur.nvx;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

class EntityLeadingMarginSpan2 implements LeadingMarginSpan.LeadingMarginSpan2 {
    private int margin;
    private int lines;

    EntityLeadingMarginSpan2(int lines, int margin) {
        this.lines = lines;
        this.margin = margin;
    }

//   Returns the value to which must be added indentation
    @Override
    public int getLeadingMargin(boolean first) {
        if (first) {
            return margin;
        } else {
      //Offset for all other Layout layout ) { }
     /*Returns * the number of rows which should be applied *     indent returned by getLeadingMargin (true)
     * Note:* Indent only applies to N lines of the first paragraph.*/
            return 0;
        }
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom, CharSequence text,
                                  int start, int end, boolean first, Layout layout) {
    }

    @Override
    public int getLeadingMarginLineCount() {
        return lines;
    }
}