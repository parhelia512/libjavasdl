package io.github.libsdl4j.api.render;

import com.sun.jna.Pointer;
import io.github.libsdl4j.api.pixels.SDL_Color;
import io.github.libsdl4j.api.rect.SDL_FPoint;
import io.github.libsdl4j.jna.PojoStructure;

/**
 * Vertex structure
 */
public final class SDL_Vertex implements PojoStructure {

    /** Vertex position X, in SDL_Renderer coordinates */
    public float positionX;

    /** Vertex position X, in SDL_Renderer coordinates */
    public float positionY;

    /** Vertex color - red */
    public byte r;

    /** Vertex color - green */
    public byte g;

    /** Vertex color - blue */
    public byte b;

    /** Vertex color - alpha */
    public byte a;

    /** Normalized texture coordinate X, if needed */
    public float texCoordX;

    /** Normalized texture coordinate Y, if needed */
    public float texCoordY;

    public SDL_Vertex() {
    }

    public SDL_Vertex(Pointer p) {
        positionX = p.getFloat(0L);
        positionY = p.getFloat(4L);
        r = p.getByte(8L);
        g = p.getByte(9L);
        b = p.getByte(10L);
        a = p.getByte(11L);
        texCoordX = p.getFloat(12L);
        texCoordY = p.getFloat(16L);
    }

    public SDL_Vertex(SDL_FPoint position, SDL_Color color, SDL_FPoint texCoord) {
        this.positionX = position.x;
        this.positionY = position.y;
        r = color.r;
        g = color.g;
        b = color.b;
        a = color.a;
        if (texCoord != null) {
            texCoordX = texCoord.x;
            texCoordY = texCoord.y;
        }
    }

    public SDL_Vertex(float positionX, float positionY, byte colorR, byte colorG, byte colorB, byte colorA, float texCoordX, float texCoordY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.r = colorR;
        this.g = colorG;
        this.b = colorB;
        this.a = colorA;
        this.texCoordX = texCoordX;
        this.texCoordY = texCoordY;
    }

    /** Vertex position, in SDL_Renderer coordinates */
    public SDL_FPoint getPosition() {
        return new SDL_FPoint(positionX, positionY);
    }

    public void setPosition(SDL_FPoint position) {
        positionX = position.x;
        positionY = position.y;
    }

    /** Vertex color */
    public SDL_Color getColor() {
        return new SDL_Color(r, g, b, a);
    }

    public void setColor(SDL_Color color) {
        r = color.r;
        g = color.g;
        b = color.b;
        a = color.a;
    }

    /** Normalized texture coordinates, if needed */
    public SDL_FPoint getTexCoord() {
        return new SDL_FPoint(texCoordX, texCoordY);
    }

    public void setTexCoord(SDL_FPoint texCoord) {
        texCoordX = texCoord.x;
        texCoordY = texCoord.y;
    }

    @Override
    public long size() {
        return 20L;
    }

    @Override
    public void write(Pointer p, long offset) {
        p.setFloat(offset, positionX);
        p.setFloat(offset + 4L, positionY);
        p.setByte(offset + 8L, r);
        p.setByte(offset + 9L, g);
        p.setByte(offset + 10L, b);
        p.setByte(offset + 11L, a);
        p.setFloat(offset + 12L, texCoordX);
        p.setFloat(offset + 16L, texCoordY);
    }
}
