package umudev.witch.discordbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import umudev.witch.discordbot.commands.ModuleHug;
import umudev.witch.discordbot.commands.ModuleTest;
import umudev.witch.discordbot.utils.configs;

import java.util.*;

public class bot {

    public static void main(String[] args) {
        DiscordApi api = new DiscordApiBuilder()
                .setToken(configs.token)
                .login().join();
        api.addListener(new ModuleTest());
        api.addListener(new ModuleHug());

        // I'm too tired to make this better.
        api.addMessageCreateListener(event -> {
            String content = event.getMessage().getContent();
            if (content.startsWith(configs.prefix + "setActivity")){

                int prefixCount = configs.prefix.length();

                List<String> Args = Arrays.asList(content.substring(11+prefixCount).trim().split(" +"));

                String activityType = Args.get(0).toLowerCase();

                String text2 = String.join(" ", Args);

                Args.set(0, "");

                String text = String.join(" ", Args);

                switch (activityType) {
                    case "watching", "w" -> api.updateActivity(ActivityType.WATCHING, text);
                    case "competing", "c" -> api.updateActivity(ActivityType.COMPETING, text);
                    case "listening", "l" -> api.updateActivity(ActivityType.LISTENING, text);
                    case "playing", "p" -> api.updateActivity(ActivityType.PLAYING, text);
                    default -> api.updateActivity(text2);
                }

            }
        });

    }

}