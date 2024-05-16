package me.spacety.terminatormod.util;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

public class TextUtil {
    public static StringTextComponent convertColorCodes(String message) {
        message = message.replace("&", "§");
        StringBuilder formattedMessage = new StringBuilder();
        StringTextComponent component = new StringTextComponent("");

        Style currentStyle = Style.EMPTY;

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == '§') {
                if (i + 1 < message.length()) {
                    char code = message.charAt(i + 1);
                    TextFormatting format = TextFormatting.fromFormattingCode(code);
                    if (format != null) {
                        if (formattedMessage.length() != 0) {
                            component.appendSibling(new StringTextComponent(formattedMessage.toString()).setStyle(currentStyle));
                            formattedMessage = new StringBuilder();
                        }
                        currentStyle = Style.EMPTY.applyFormatting(format);
                        i++;
                        continue;
                    }
                }
            }
            formattedMessage.append(c);
        }

        if (formattedMessage.length() != 0) {
            component.appendSibling(new StringTextComponent(formattedMessage.toString()).setStyle(currentStyle));
        }

        return component;
    }
}
