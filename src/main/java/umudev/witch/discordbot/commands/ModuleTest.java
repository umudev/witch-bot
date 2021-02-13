package umudev.witch.discordbot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import umudev.witch.discordbot.utils.configs;

public class ModuleTest implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase(configs.prefix + "test")) {
            event.getChannel().sendMessage("Yooo it works!");
        }
    }

}
