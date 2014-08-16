package com.theredpixelteam.trp3.gui;

import static org.lwjgl.opengl.GL11.glColor4f;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiUtils {
	
	public static void color( final int color ) {
		final float alpha = ( ( color >> 24 ) & 255 ) / 255.0F;
		final float red = ( ( color >> 16 ) & 255 ) / 255.0F;
		final float green = ( ( color >> 8 ) & 255 ) / 255.0F;
		final float blue = ( color & 255 ) / 255.0F;
		GL11.glColor4f( red, green, blue, alpha );
	}
	
	public static void setColor(Color c) {
		glColor4f(c.getRed() / 255f, c.getGreen() / 255f, c.getBlue() / 255f, c.getAlpha() / 255f);
	}
	
	public static float[ ] getColor( final int color ) {
		final float alpha = ( ( color >> 24 ) & 255 ) / 255.0F;
		final float red = ( ( color >> 16 ) & 255 ) / 255.0F;
		final float green = ( ( color >> 8 ) & 255 ) / 255.0F;
		final float blue = ( color & 255 ) / 255.0F;
		return new float[ ] {
				red, green, blue, alpha
		};
	}
	
	public static FontRenderer getFontRenderer( ) {
		return Minecraft.getMinecraft( ).fontRenderer;
	}
	
	public static int getWidth( ) {
		final ScaledResolution sr = getScaledResolution( );
		return sr.getScaledWidth( );
	}
	
	public static int getHeight( ) {
		final ScaledResolution sr = getScaledResolution( );
		return sr.getScaledHeight( );
	}
	

	
	public static ScaledResolution getScaledResolution( ) {
		final ScaledResolution sr = new ScaledResolution( Minecraft.getMinecraft( ).gameSettings,
				Minecraft.getMinecraft( ).displayWidth, Minecraft.getMinecraft( ).displayHeight );
		return sr;
	}
	
	/**
	 * posX, posY, width, height, color(top), color(bottom)
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param color
	 * @param color2
	 */
    public static void drawGradientRect(final double x, final double y, final double w, final double h, final int color, final int color2)
    {
    	final float var7 = ( ( color >> 24 ) & 255 ) / 255.0F;
		final float var8 = ( ( color >> 16 ) & 255 ) / 255.0F;
		final float var9 = ( ( color >> 8 ) & 255 ) / 255.0F;
		final float var10 = ( color & 255 ) / 255.0F;
		final float var11 = ( ( color2 >> 24 ) & 255 ) / 255.0F;
		final float var12 = ( ( color2 >> 16 ) & 255 ) / 255.0F;
		final float var13 = ( ( color2 >> 8 ) & 255 ) / 255.0F;
		final float var14 = ( color2 & 255 ) / 255.0F;
		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_ALPHA_TEST );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
		GL11.glShadeModel( GL11.GL_SMOOTH );
		final Tessellator var15 = Tessellator.instance;
		var15.startDrawingQuads( );
		var15.setColorRGBA_F( var8, var9, var10, var7 );
		var15.addVertex( x + w, y, 0 );
		var15.addVertex( x, y, 0 );
		var15.setColorRGBA_F( var12, var13, var14, var11 );
		var15.addVertex( x, y + h, 0 );
		var15.addVertex( x + w, y + h, 0 );
		var15.draw( );
		GL11.glShadeModel( GL11.GL_FLAT );
		GL11.glDisable( GL11.GL_BLEND );
		GL11.glEnable( GL11.GL_ALPHA_TEST );
		GL11.glEnable( GL11.GL_TEXTURE_2D );
    }
    
    public static void drawBorderedRect( final double x, final double y, final double w, final double h, final float lineWidth, final int color, final int color1 ) {
		drawRect( x, y, w, h, color1 );

		final float var7 = ( ( color >> 24 ) & 255 ) / 255.0F;
		final float var8 = ( ( color >> 16 ) & 255 ) / 255.0F;
		final float var9 = ( ( color >> 8 ) & 255 ) / 255.0F;
		final float var10 = ( color & 255 ) / 255.0F;

		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_ALPHA_TEST );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );

		GL11.glLineWidth( lineWidth );

		final Tessellator var15 = Tessellator.instance;
		var15.startDrawing( GL11.GL_LINE_LOOP );

		var15.setColorRGBA_F( var8, var9, var10, var7 );

		var15.addVertex( x, y, 1 );
		var15.addVertex( x + w, y, 1 );
		var15.addVertex( x + w, y + h, 1 );
		var15.addVertex( x, y + h, 1 );
		var15.draw( );

		GL11.glDisable( GL11.GL_BLEND );
		GL11.glEnable( GL11.GL_ALPHA_TEST );
		GL11.glEnable( GL11.GL_TEXTURE_2D );
	}
    
    public static void drawGradientBorderedRect( final double x, final double y, final double w,
			final double h, final float lineWidth, final int color, final int color1, final int color2 ) {
		drawGradientRect( x, y, w, h, color1, color2 );

		final float var7 = ( ( color >> 24 ) & 255 ) / 255.0F;
		final float var8 = ( ( color >> 16 ) & 255 ) / 255.0F;
		final float var9 = ( ( color >> 8 ) & 255 ) / 255.0F;
		final float var10 = ( color & 255 ) / 255.0F;

		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_ALPHA_TEST );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );

		GL11.glLineWidth( lineWidth );

		final Tessellator var15 = Tessellator.instance;
		var15.startDrawing( GL11.GL_LINE_LOOP );

		var15.setColorRGBA_F( var8, var9, var10, var7 );

		var15.addVertex( x, y, 0 );
		var15.addVertex( x + w, y, 0 );
		var15.addVertex( x + w, y + h, 0 );
		var15.addVertex( x, y + h, 0 );
		var15.draw( );

		GL11.glDisable( GL11.GL_BLEND );
		GL11.glEnable( GL11.GL_ALPHA_TEST );
		GL11.glEnable( GL11.GL_TEXTURE_2D );
	}
    
    public static void drawSideGradientRect( final double x, final double y, final double w, final double h,
			final int color, final int color2 ) {
		final float var7 = ( ( color >> 24 ) & 255 ) / 255.0F;
		final float var8 = ( ( color >> 16 ) & 255 ) / 255.0F;
		final float var9 = ( ( color >> 8 ) & 255 ) / 255.0F;
		final float var10 = ( color & 255 ) / 255.0F;
		final float var11 = ( ( color2 >> 24 ) & 255 ) / 255.0F;
		final float var12 = ( ( color2 >> 16 ) & 255 ) / 255.0F;
		final float var13 = ( ( color2 >> 8 ) & 255 ) / 255.0F;
		final float var14 = ( color2 & 255 ) / 255.0F;
		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_ALPHA_TEST );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
		GL11.glShadeModel( GL11.GL_SMOOTH );
		final Tessellator var15 = Tessellator.instance;
		var15.startDrawingQuads( );
		var15.setColorRGBA_F( var8, var9, var10, var7 );
		var15.addVertex( x, y, 0 );
		var15.addVertex( x, y + h, 0 );
		var15.setColorRGBA_F( var12, var13, var14, var11 );
		var15.addVertex( x + w, y + h, 0 );
		var15.addVertex( x + w, y, 0 );
		var15.draw( );
		GL11.glShadeModel( GL11.GL_FLAT );
		GL11.glDisable( GL11.GL_BLEND );
		GL11.glEnable( GL11.GL_ALPHA_TEST );
		GL11.glEnable( GL11.GL_TEXTURE_2D );
	}

	public static void drawCircle( final double x, final double y, final double r, final int c ) {
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glEnable( GL11.GL_POLYGON_SMOOTH );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
		GL11.glHint( GL11.GL_POLYGON_SMOOTH_HINT, GL11.GL_NICEST );
		color( c );

		final Tessellator tess = Tessellator.instance;

		tess.startDrawing( GL11.GL_POLYGON );
		for( int i = 0; i <= 360; i++ ) {
			final double x2 = Math.sin( ( ( i * 3.141526D ) / 180 ) ) * r;
			final double y2 = Math.cos( ( ( i * 3.141526D ) / 180 ) ) * r;
			tess.addVertex( x + x2, y + y2, 0 );
		}
		tess.draw( );
		GL11.glDisable( GL11.GL_POLYGON_SMOOTH );
		GL11.glEnable( GL11.GL_TEXTURE_2D );
		GL11.glDisable( GL11.GL_BLEND );
	}
	
	public static void drawWedge( final double x, final double y, final double rotation, final double r,
			final double size, final int c ) {
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glEnable( GL11.GL_POLYGON_SMOOTH );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
		GL11.glHint( GL11.GL_POLYGON_SMOOTH_HINT, GL11.GL_NICEST );
		GL11.glTranslated( x, y, 0D );
		GL11.glRotated( rotation, 0D, 0D, 1D );
		color( c );

		final Tessellator tess = Tessellator.instance;

		tess.startDrawing( GL11.GL_POLYGON );
		tess.addVertex( 0D, 0D, 0D );
		for( int i = 0; i <= size; i++ ) {
			final double x2 = Math.sin( ( ( i * 3.141526D ) / 180D ) ) * r;
			final double y2 = Math.cos( ( ( i * 3.141526D ) / 180D ) ) * r;
			tess.addVertex( x2, y2, 0D );
		}
		tess.draw( );

		GL11.glRotated( -rotation, 0D, 0D, 1D );
		GL11.glTranslated( -x, -y, 0D );
		GL11.glDisable( GL11.GL_POLYGON_SMOOTH );
		GL11.glEnable( GL11.GL_TEXTURE_2D );
		GL11.glDisable( GL11.GL_BLEND );
	}
	
	public static void drawRotatedString( final String text, final double x, final double y,
			final double rotation ) {
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glEnable( GL11.GL_POLYGON_SMOOTH );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
		GL11.glHint( GL11.GL_POLYGON_SMOOTH_HINT, GL11.GL_NICEST );
		GL11.glTranslated( x, y, 0 );
		GL11.glRotated( rotation, 0, 0, 1 );

		Minecraft.getMinecraft( ).fontRenderer.drawString( text, ( int ) x, ( int ) y, 0xffffff );

		GL11.glRotated( -rotation, 0, 0, 1 );
		GL11.glTranslated( -x, -y, 0 );
		GL11.glDisable( GL11.GL_POLYGON_SMOOTH );
		GL11.glDisable( GL11.GL_BLEND );
	}
	
	public static void drawGradientCircle( final double x, final double y, final double r, final int c,
			final int c2 ) {
		// 0xAARRGGBB
		final float f = ( ( c >> 24 ) & 0xff ) / 255F;
		final float f1 = ( ( c >> 16 ) & 0xff ) / 255F;
		final float f2 = ( ( c >> 8 ) & 0xff ) / 255F;
		final float f3 = ( c & 0xff ) / 255F;
		final float g = ( ( c2 >> 24 ) & 0xff ) / 255F;
		final float g1 = ( ( c2 >> 16 ) & 0xff ) / 255F;
		final float g2 = ( ( c2 >> 8 ) & 0xff ) / 255F;
		final float g3 = ( c2 & 0xff ) / 255F;
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glEnable( GL11.GL_POLYGON_SMOOTH );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
		GL11.glHint( GL11.GL_POLYGON_SMOOTH_HINT, GL11.GL_NICEST );
		GL11.glShadeModel( GL11.GL_SMOOTH );

		final Tessellator tess = Tessellator.instance;

		tess.startDrawing( GL11.GL_POLYGON );
		tess.setColorRGBA_F( f1, f2, f3, f );
		tess.addVertex( x, y, 0 );
		tess.setColorRGBA_F( g1, g2, g3, g );
		for( int i = 1; i <= 360; i++ ) {
			final double x2 = Math.sin( ( ( i * 3.141526D ) / 180 ) ) * r;
			final double y2 = Math.cos( ( ( i * 3.141526D ) / 180 ) ) * r;
			tess.addVertex( x + x2, y + y2, 0 );
		}
		tess.draw( );

		GL11.glShadeModel( GL11.GL_FLAT );
		GL11.glDisable( GL11.GL_POLYGON_SMOOTH );
		GL11.glEnable( GL11.GL_TEXTURE_2D );
		GL11.glDisable( GL11.GL_BLEND );
	}
	
	public static void drawRect( final double x, final double y, final double w, final double h,
			final int color ) {
		final Tessellator tess = Tessellator.instance;

		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );

		color( color );

		tess.startDrawingQuads( );
		tess.addVertex( x, y, 0 );
		tess.addVertex( x, y + h, 0 );
		tess.addVertex( x + w, y + h, 0 );
		tess.addVertex( x + w, y, 0 );
		tess.draw( );

		GL11.glEnable( GL11.GL_TEXTURE_2D );
		GL11.glDisable( GL11.GL_BLEND );
	}
	
    protected static void drawGradientRect1(double par1, double par2, double par3, double par4, int par5, int par6)
    {
        float f = (float)(par5 >> 24 & 255) / 255.0F;
        float f1 = (float)(par5 >> 16 & 255) / 255.0F;
        float f2 = (float)(par5 >> 8 & 255) / 255.0F;
        float f3 = (float)(par5 & 255) / 255.0F;
        float f4 = (float)(par6 >> 24 & 255) / 255.0F;
        float f5 = (float)(par6 >> 16 & 255) / 255.0F;
        float f6 = (float)(par6 >> 8 & 255) / 255.0F;
        float f7 = (float)(par6 & 255) / 255.0F;
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f1, f2, f3, f);
        tessellator.addVertex((double)par3, (double)par2, (double)0);
        tessellator.addVertex((double)par1, (double)par2, (double)0);
        tessellator.setColorRGBA_F(f5, f6, f7, f4);
        tessellator.addVertex((double)par1, (double)par4, (double)0);
        tessellator.addVertex((double)par3, (double)par4, (double)0);
        tessellator.draw();
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
    
	public static void DrawCircle(float cx, float cy, float r, int num_segments, int c) {
		float f = (float) (c >> 24 & 0xff) / 255F;
		float f1 = (float) (c >> 16 & 0xff) / 255F;
		float f2 = (float) (c >> 8 & 0xff) / 255F;
		float f3 = (float) (c & 0xff) / 255F;
		float theta = (float) (2 * 3.1415926 / (num_segments));
		float p = (float) Math.cos(theta);// calculate the sine and cosine
		float s = (float) Math.sin(theta);
		float t;
		GL11.glColor4f(f1, f2, f3, f);
		float x = r;
		float y = 0;// start at angle = 0
		GL11.glEnable(3042 /* GL_BLEND */);
		GL11.glDisable(3553 /* GL_TEXTURE_2D */);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBlendFunc(770, 771);
		GL11.glBegin(GL11.GL_LINE_LOOP);
		for (int ii = 0; ii < num_segments; ii++) {
			GL11.glVertex2f(x + cx, y + cy);// final vertex vertex

			// rotate the stuff
			t = x;
			x = p * x - s * y;
			y = s * t + p * y;
		}
		GL11.glEnd();
		GL11.glEnable(3553 /* GL_TEXTURE_2D */);
		GL11.glDisable(3042 /* GL_BLEND */);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}
	
	public static void DrawFullCircle(int cx, int cy, double r, int c) {
		float f = (float) (c >> 24 & 0xff) / 255F;
		float f1 = (float) (c >> 16 & 0xff) / 255F;
		float f2 = (float) (c >> 8 & 0xff) / 255F;
		float f3 = (float) (c & 0xff) / 255F;
		GL11.glEnable(3042 /* GL_BLEND */);
		GL11.glDisable(3553 /* GL_TEXTURE_2D */);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBlendFunc(770, 771);
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		for (int i = 0; i <= 360; i++) {
			double x = Math.sin((i * 3.141526D / 180)) * r;
			double y = Math.cos((i * 3.141526D / 180)) * r;
			GL11.glVertex2d(cx + x, cy + y);
		}
		GL11.glEnd();
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(3553 /* GL_TEXTURE_2D */);
		GL11.glDisable(3042 /* GL_BLEND */);
	}
	
	public static void drawTri(int cx, int cy, int c) {
		GL11.glRotatef(180, 0F, 0F, 1.0F);
		float f = (float) (c >> 24 & 0xff) / 255F;
		float f1 = (float) (c >> 16 & 0xff) / 255F;
		float f2 = (float) (c >> 8 & 0xff) / 255F;
		float f3 = (float) (c & 0xff) / 255F;
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glEnable(3042 /* GL_BLEND */);
		GL11.glDisable(3553 /* GL_TEXTURE_2D */);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBlendFunc(770, 771);
		GL11.glBegin(GL11.GL_TRIANGLES);

		GL11.glVertex2d(cx, cy + 2);
		GL11.glVertex2d(cx + 2, cy - 2);
		GL11.glVertex2d(cx - 2, cy - 2);

		GL11.glEnd();
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(3553 /* GL_TEXTURE_2D */);
		GL11.glDisable(3042 /* GL_BLEND */);
		GL11.glRotatef(-180, 0F, 0F, 1.0F);
	}
	
    public static void drawEntity(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_147046_0_, (float)p_147046_1_, 50.0F);
        GL11.glScalef((float)(-p_147046_2_), (float)p_147046_2_, (float)p_147046_2_);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = p_147046_5_.renderYawOffset;
        float f3 = p_147046_5_.rotationYaw;
        float f4 = p_147046_5_.rotationPitch;
        float f5 = p_147046_5_.prevRotationYawHead;
        float f6 = p_147046_5_.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        p_147046_5_.renderYawOffset = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 20.0F;
        p_147046_5_.rotationYaw = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 40.0F;
        p_147046_5_.rotationPitch = -((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F;
        p_147046_5_.rotationYawHead = p_147046_5_.rotationYaw;
        p_147046_5_.prevRotationYawHead = p_147046_5_.rotationYaw;
        GL11.glTranslatef(0.0F, p_147046_5_.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(p_147046_5_, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        p_147046_5_.renderYawOffset = f2;
        p_147046_5_.rotationYaw = f3;
        p_147046_5_.rotationPitch = f4;
        p_147046_5_.prevRotationYawHead = f5;
        p_147046_5_.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    public static void drawWindow(int x, int y, int width, int height, int color)
    {
        drawPoint(x+3,y+1, color);
        drawPoint(x+4,y+1, color);
        drawPoint(x+2,y+2, color);
        drawPoint(x+1,y+3, color);
        drawPoint(x+1,y+4, color);
        drawVerticalline(x,y+5,height-4,color);
        drawHorizontalline(x+5,y,width-4,color);
        drawPoint(x+1, height-4,color);
        drawPoint(x+1, height-3,color);
        drawPoint(x+2, height-2,color);
        drawPoint(x+3, height-1,color);
        drawPoint(x+4, height-1,color);
        drawHorizontalline(x+5,height,width-4, color);
        drawPoint(width-1,height-4,color);
        drawPoint(width-1,height-3,color);
        drawPoint(width-2,height-2, color);
        drawPoint(width-3,height-1,color);
        drawPoint(width-4,height-1,color);
        drawVerticalline(width,y+5,height-4, color);
        drawPoint(width-1,y+4,color);
        drawPoint(width-1,y+3,color);
        drawPoint(width-2,y+2,color);
        drawPoint(width-3,y+1,color);
        drawPoint(width-4,y+1,color);
    }
    public static void drawcoloredwindow (int x, int y, int x2, int y2, int color1, int color2)
    {
        drawWindow(x,y,x2,y2,color1);
        drawRect(x+5, y+1, x2-4,y+2, color2);
        drawRect(x+3, y+2, x2-2, y+3, color2);
        drawRect(x+2, y+3, x2-1, y+5, color2);
        drawRect(x+1,   y+5, x2  , y+(y2-y-4)   , color2);
        drawRect(x2-4,y2-1,x+5,y2,color2);
        drawRect(x2-1, y2-2,x+2,y2-4,color2);
        drawRect(x+3,y2-2,x2-2,y2-1,color2);
    }
    public static void drawcoloredwindowwithstring (String s, int x, int y, int x2, int y2, int color1, int color2)
    {GL11.glScaled(.5,.5,.5);
        drawcoloredwindow(x,y,x2,y2,color1,color2);
        Minecraft.getMinecraft().fontRenderer.drawString(s, x+5, y+4, 0xffffff);
        GL11.glScaled(2,2,2);
        
    }
    public static void drawVerticalline(int x, int y, int height,int color)
    {
        drawRect (x,y,x + 1,height,color);
    }
    public static void drawHorizontalline(int x, int y, int width, int color)
    {
        drawRect(x, y,  width, y+1, color);
    }
    public static void drawPoint(int x, int y, int color)
    {
        drawRect(x,y,x+1,y+1,color);
    }


    public static void drawcoloredwindowa(String s,int x, int y, int x2, int y2, int color1, int color2)
    {
        
        //GL11.glScaled(.5,.5,.5);
        drawcoloredwindow(x,y,x2,y2,color1,color2);
        //drawWindow(x2-14,y+4,x2-4,y+14,0x80000000);
        //drawWindow(x2-26,y+4,x2-16,y+14,0x80000000);
        drawRect(x+10, y+25, x2-9, y+26, 0x80000000);
        Minecraft.getMinecraft().fontRenderer.drawString(s, x+10, y+8, 0xffffff);
        //GL11.glScaled(2,2,2);
    }
    
	public static void drawHLine(final double x, final double y, final double w, final int color, double speed) {
		final Tessellator tess = Tessellator.instance;

		GL11.glEnable( GL11.GL_BLEND );
		GL11.glDisable( GL11.GL_TEXTURE_2D );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );

		color( color );

		/*tess.startDrawingQuads( );
		tess.addVertex( x, y, 0 );
		tess.addVertex( x, y + h, 0 );
		tess.addVertex( x + w, y + h, 0 );
		tess.addVertex( x + w, y, 0 );
		tess.draw( );*/
		
		//GL11.glBegin(GL11.GL_POINTS);
		for(double i = x; i < w; i += speed) {
			GL11.glPointSize(2.0f);
			GL11.glBegin(GL11.GL_POINTS);
			GL11.glVertex2d(x + i,y);
			GL11.glEnd();
			GL11.glFlush();
		}


		GL11.glEnable( GL11.GL_TEXTURE_2D );
		GL11.glDisable( GL11.GL_BLEND );
	}
	
}
