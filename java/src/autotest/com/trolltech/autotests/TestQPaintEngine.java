/****************************************************************************
**
** Copyright (C) 1992-2009 Nokia. All rights reserved.
**
** This file is part of Qt Jambi.
**
** ** $BEGIN_LICENSE$
** Commercial Usage
** Licensees holding valid Qt Commercial licenses may use this file in
** accordance with the Qt Commercial License Agreement provided with the
** Software or, alternatively, in accordance with the terms contained in
** a written agreement between you and Nokia.
** 
** GNU Lesser General Public License Usage
** Alternatively, this file may be used under the terms of the GNU Lesser
** General Public License version 2.1 as published by the Free Software
** Foundation and appearing in the file LICENSE.LGPL included in the
** packaging of this file.  Please review the following information to
** ensure the GNU Lesser General Public License version 2.1 requirements
** will be met: http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html.
** 
** In addition, as a special exception, Nokia gives you certain
** additional rights. These rights are described in the Nokia Qt LGPL
** Exception version 1.0, included in the file LGPL_EXCEPTION.txt in this
** package.
** 
** GNU General Public License Usage
** Alternatively, this file may be used under the terms of the GNU
** General Public License version 3.0 as published by the Free Software
** Foundation and appearing in the file LICENSE.GPL included in the
** packaging of this file.  Please review the following information to
** ensure the GNU General Public License version 3.0 requirements will be
** met: http://www.gnu.org/copyleft/gpl.html.
** 
** If you are unsure which license is appropriate for your use, please
** contact the sales department at qt-sales@nokia.com.
** $END_LICENSE$

**
** This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
** WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
**
****************************************************************************/

package com.trolltech.autotests;

import org.junit.Test;

import com.trolltech.autotests.generated.CustomPaintEngine;
import com.trolltech.autotests.generated.OtherCustomPaintEngine;
import com.trolltech.qt.core.QPoint;
import com.trolltech.qt.core.QPointF;
import com.trolltech.qt.core.QRect;
import com.trolltech.qt.core.QRectF;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QLine;
import com.trolltech.qt.gui.QLineF;
import com.trolltech.qt.gui.QPaintDeviceInterface;
import com.trolltech.qt.gui.QPaintEngine;
import com.trolltech.qt.gui.QPaintEngineState;
import com.trolltech.qt.gui.QPixmap;
import static org.junit.Assert.*;

public class TestQPaintEngine extends CustomPaintEngine
{

    @Override
    public boolean begin(QPaintDeviceInterface pdev) {
        return true;
    }

    @Override
    public void drawPixmap(QRectF r, QPixmap pm, QRectF sr) {
    }

    @Override
    public boolean end() {
        return true;
    }

    @Override
    public Type type() {
        return QPaintEngine.Type.resolve(QPaintEngine.Type.User.value() + 1);
    }

    @Override
    public void updateState(QPaintEngineState state) {

    }

    private int length = 0;
    private Object object = null;

    void setArray(Object array[]) {
        if (array == null) {
            length = -1;
            object = null;
        } else {
            length = array.length;
            object = array[0];
        }
    }

    /**
     * drawLines(const QLine *, int)
     */

    @Override
    public void drawLines(QLine[] lines) {
        setArray(lines);
    }

    @Test
    public void testVirtualDrawLines() {
        callDrawLines(new QLine(1, 2, 3, 4), 11);

        assertEquals(11, length);

        QLine line = (QLine) object;
        assertEquals(1, line.x1());
        assertEquals(2, line.y1());
        assertEquals(3, line.x2());
        assertEquals(4, line.y2());
    }

    @Test
    public void testVirtualDrawLinesNull() {
        callDrawLines(null, 0);

        assertEquals(-1, length);
        assertEquals(null, object);
    }

    @Test
    public void testDrawLines() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        QLine lines[] = new QLine[13];
        lines[0] = new QLine(2, 3, 4, 5);
        for (int i=1; i<lines.length; ++i)
            lines[i] = new QLine();

        p.drawLines(lines);

        assertEquals(13, p.length());

        QLine line = p.line();
        assertEquals(2, line.x1());
        assertEquals(3, line.y1());
        assertEquals(4, line.x2());
        assertEquals(5, line.y2());
    }

    @Test
    public void testDrawLinesNull() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        p.drawLines((QLine[]) null);

        assertEquals(-1, p.length());
    }

    /**
     * drawLines(const QLineF *, int)
     **/

    @Override
    public void drawLines(QLineF lines[]) {
        setArray(lines);
    }

    @Test
    public void testVirtualDrawLineFs() {
        callDrawLineFs(new QLineF(1.2, 2.3, 3.4, 4.5), 11);

        assertEquals(11, length);

        QLineF line = (QLineF) object;
        assertEquals(1.2, line.x1());
        assertEquals(2.3, line.y1());
        assertEquals(3.4, line.x2());
        assertEquals(4.5, line.y2());
    }

    @Test
    public void testVirtualDrawLineFsNull() {
        callDrawLineFs(null, 0);

        assertEquals(-1, length);
        assertEquals(null, object);
    }

    @Test
    public void testDrawLineFs() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        QLineF lines[] = new QLineF[13];
        lines[0] = new QLineF(2.3, 3.4, 4.5, 5.6);
        for (int i=1; i<lines.length; ++i)
            lines[i] = new QLineF();

        p.drawLines(lines);

        assertEquals(13, p.length());

        QLineF line = p.lineF();
        assertEquals(2.3, line.x1());
        assertEquals(3.4, line.y1());
        assertEquals(4.5, line.x2());
        assertEquals(5.6, line.y2());
    }

    @Test
    public void testDrawLineFsNull() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        p.drawLines((QLineF[]) null);

        assertEquals(-1, p.length());
    }

    /**
     * drawRects(const QRectF *, int)
     **/

    @Override
    public void drawRects(QRectF lines[]) {
        setArray(lines);
    }

    @Test
    public void testVirtualDrawRectFs() {
        callDrawRectFs(new QRectF(1.2, 2.3, 3.4, 4.5), 11);

        assertEquals(11, length);

        QRectF rect = (QRectF) object;
        assertEquals(1.2, rect.x());
        assertEquals(2.3, rect.y());
        assertEquals(3.4, rect.width());
        assertEquals(4.5, rect.height());
    }

    @Test
    public void testVirtualDrawRectFsNull() {
        callDrawRectFs(null, 0);

        assertEquals(-1, length);
        assertEquals(null, object);
    }

    @Test
    public void testDrawRectFs() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        QRectF rects[] = new QRectF[13];
        rects[0] = new QRectF(2.3, 3.4, 4.5, 5.6);
        for (int i=1; i<rects.length; ++i)
            rects[i] = new QRectF();

        p.drawRects(rects);

        assertEquals(13, p.length());

        QRectF rect = p.rectF();
        assertEquals(2.3, rect.x());
        assertEquals(3.4, rect.y());
        assertEquals(4.5, rect.width());
        assertEquals(5.6, rect.height());
    }

    @Test
    public void testDrawRectFsNull() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        p.drawRects((QRectF[]) null);

        assertEquals(-1, p.length());
    }

    /**
     * drawRects(const QRect *, int)
     **/

    @Override
    public void drawRects(QRect lines[]) {
        setArray(lines);
    }

    @Test
    public void testVirtualDrawRects() {
        callDrawRects(new QRect(1, 2, 3, 4), 11);

        assertEquals(11, length);

        QRect rect = (QRect) object;
        assertEquals(1, rect.x());
        assertEquals(2, rect.y());
        assertEquals(3, rect.width());
        assertEquals(4, rect.height());
    }

    @Test
    public void testVirtualDrawRectsNull() {
        callDrawRects(null, 0);

        assertEquals(-1, length);
        assertEquals(null, object);
    }

    @Test
    public void testDrawRects() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        QRect rects[] = new QRect[13];
        rects[0] = new QRect(2, 3, 4, 5);
        for (int i=1; i<rects.length; ++i)
            rects[i] = new QRect();

        p.drawRects(rects);

        assertEquals(13, p.length());

        QRect rect = p.rect();
        assertEquals(2, rect.x());
        assertEquals(3, rect.y());
        assertEquals(4, rect.width());
        assertEquals(5, rect.height());
    }

    @Test
    public void testDrawRectsNull() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        p.drawRects((QRect[]) null);

        assertEquals(-1, p.length());
    }

    /**
     * drawPoints(const QPoint *, int)
     **/

    @Override
    public void drawPoints(QPoint lines[]) {
        setArray(lines);
    }

    @Test
    public void testVirtualDrawPoints() {
        callDrawPoints(new QPoint(1, 2), 11);

        assertEquals(11, length);

        QPoint point = (QPoint) object;
        assertEquals(1, point.x());
        assertEquals(2, point.y());
    }

    @Test
    public void testVirtualDrawPointsNull() {
        callDrawPoints(null, 0);

        assertEquals(-1, length);
        assertEquals(null, object);
    }

    @Test
    public void testDrawPoints() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        QPoint points[] = new QPoint[13];
        points[0] = new QPoint(2, 3);
        for (int i=1; i<points.length; ++i)
            points[i] = new QPoint();

        p.drawPoints(points);

        assertEquals(13, p.length());

        QPoint point = p.point();
        assertEquals(2, point.x());
        assertEquals(3, point.y());
    }

    @Test
    public void testDrawPointsNull() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        p.drawPoints((QPoint[]) null);

        assertEquals(-1, p.length());
    }

    /**
     * drawPoints(const QPointF *, int)
     **/

    @Override
    public void drawPoints(QPointF lines[]) {
        setArray(lines);
    }

    @Test
    public void testVirtualDrawPointFs() {
        callDrawPointFs(new QPointF(1.0, 2.0), 11);

        assertEquals(11, length);

        QPointF pointF = (QPointF) object;
        assertEquals(1.0, pointF.x());
        assertEquals(2.0, pointF.y());
    }

    @Test
    public void testVirtualDrawPointFsNull() {
        callDrawPointFs(null, 0);

        assertEquals(-1, length);
        assertEquals(null, object);
    }

    @Test
    public void testDrawPointFs() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        QPointF pointFs[] = new QPointF[13];
        pointFs[0] = new QPointF(2.0, 3.0);
        for (int i=1; i<pointFs.length; ++i)
            pointFs[i] = new QPointF();

        p.drawPoints(pointFs);

        assertEquals(13, p.length());

        QPointF pointF = p.pointF();
        assertEquals(2.0, pointF.x());
        assertEquals(3.0, pointF.y());
    }

    @Test
    public void testDrawPointFsNull() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        p.drawPoints((QPointF[]) null);

        assertEquals(-1, p.length());
    }

    /**
     * drawPolygon(const QPointF *, int)
     **/

    @Override
    public void drawPolygon(QPointF lines[], QPaintEngine.PolygonDrawMode mode) {
        setArray(lines);
    }

    @Test
    public void testVirtualDrawPolygonFs() {
        callDrawPolygonFs(new QPointF(1.0, 2.0), 11);

        assertEquals(11, length);

        QPointF pointF = (QPointF) object;
        assertEquals(1.0, pointF.x());
        assertEquals(2.0, pointF.y());
    }

    @Test
    public void testVirtualDrawPolygonFsNull() {
        callDrawPolygonFs(null, 0);

        assertEquals(-1, length);
        assertEquals(null, object);
    }

    @Test
    public void testDrawPolygonFs() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        QPointF pointFs[] = new QPointF[13];
        pointFs[0] = new QPointF(2.0, 3.0);
        for (int i=1; i<pointFs.length; ++i)
            pointFs[i] = new QPointF();

        p.drawPolygon(pointFs, QPaintEngine.PolygonDrawMode.OddEvenMode);

        assertEquals(13, p.length());

        QPointF pointF = p.pointF();
        assertEquals(2.0, pointF.x());
        assertEquals(3.0, pointF.y());
    }

    /**
     * drawPolygon(const QPoint *, int)
     **/

    @Override
    public void drawPolygon(QPoint lines[], QPaintEngine.PolygonDrawMode mode) {
        setArray(lines);
    }

    @Test
    public void testVirtualDrawPolygons() {
        callDrawPolygons(new QPoint(1, 2), 11);

        assertEquals(11, length);

        QPoint point = (QPoint) object;
        assertEquals(1, point.x());
        assertEquals(2, point.y());
    }

    @Test
    public void testVirtualDrawPolygonsNull() {
        callDrawPolygons(null, 0);

        assertEquals(-1, length);
        assertEquals(null, object);
    }

    @Test
    public void testDrawPolygons() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        QPoint points[] = new QPoint[13];
        points[0] = new QPoint(2, 3);
        for (int i=1; i<points.length; ++i)
            points[i] = new QPoint();

        p.drawPolygon(points, QPaintEngine.PolygonDrawMode.OddEvenMode);

        assertEquals(13, p.length());

        QPoint point = p.point();
        assertEquals(2, point.x());
        assertEquals(3, point.y());
    }

    @Test
    public void testDrawPolygonsNull() {
        OtherCustomPaintEngine p = new OtherCustomPaintEngine();

        p.drawPolygon((QPoint[]) null, QPaintEngine.PolygonDrawMode.OddEvenMode);

        assertEquals(-1, p.length());
    }

    public static void main(String args[]) {
        QApplication.initialize(args);
        TestQPaintEngine p = new TestQPaintEngine();
        p.testDrawLines();
        p.testDrawLinesNull();
        p.testVirtualDrawLines();
        p.testVirtualDrawLinesNull();
    }
}