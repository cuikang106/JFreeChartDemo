/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfreechartdemo;

import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Cui Kang
 */
public class BarExample1 extends ApplicationFrame{
    
    public BarExample1(String title){
        super(title);
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        //插入数据，Row为数据系列，Colum为种类
        dataset.addValue(1.0, "Row 1","Colum 1");
        dataset.addValue(5.0, "Row 1", "Colum 2");
        dataset.addValue(3.0, "Row 1", "Colum 3");
        dataset.addValue(2.0, "Row 2", "Colum 1");
        dataset.addValue(7.0,"Row 3","Colum 3");
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo",
                "Category", "Value", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.WHITE);//改变图标外围的背景色
        CategoryPlot plot = (CategoryPlot) chart.getPlot();//获取图标的区域的引用
        plot.setBackgroundPaint(Color.LIGHT_GRAY);//改变图表的背景色
        plot.setRangeGridlinePaint(Color.white);//改变水平轴网格线的颜色
        BarRenderer renderer = (BarRenderer)plot.getRenderer();//获取直方图的绘图实例
        renderer.setSeriesPaint(0,Color.GRAY);//改变系列的颜色
        renderer.setSeriesPaint(1, Color.ORANGE);
        renderer.setSeriesPaint(2, Color.blue);
        renderer.setItemMargin(0.3);
        ChartPanel chartPanel = new ChartPanel(chart,false);
        chartPanel.setPreferredSize(new Dimension(500,270));
        setContentPane(chartPanel);
    }
    
    public static void main(String[] args){
        BarExample1 demo = new BarExample1("Bar Demo1");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
