package umudev.witch.discordbot.commands;

import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import umudev.witch.discordbot.utils.configs;

import java.util.Random;

import java.util.List;

public class ModuleHug implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {

        String content = event.getMessage().getContent();

        if (content.startsWith(configs.prefix + "hug")) {
            List<User> users = event.getMessage().getMentionedUsers();

            String[] hugs = {"(っ^_^)っ", "(つﾟ⊿ﾟ)つ", "(づ｡◕‿‿◕｡)づ", "(づ￣ ³￣)づ", "(っ˘̩╭╮˘̩)っ", "(੭ु｡╹▿╹｡)੭ु⁾⁾",
                    "(っ´▽｀)っ", "(っ´∀｀)っ","c⌒っ╹v╹ )っ", "(σ･з･)σ", "(੭ु´･ω･`)੭ु⁾⁾", "(oﾟ▽ﾟ)o", "༼つ ் ▽ ் ༽つ",
                    "༼ つ ̥◕͙_̙◕͖ ͓༽つ","༼ つ ◕o◕ ༽つ","༼ つ ◕_◕ ༽つ","ʕっ•ᴥ•ʔっ","ʕ ⊃･ ◡ ･ ʔ⊃","(⊃｡•́‿•̀｡)⊃","(.づ◡﹏◡)づ.",
                    "(.づσ▿σ)づ.","（っ・∀・）っ","(つ´∀｀)つ","(っ*´∀｀*)っ","(> ^_^ )>","( > ^ _ ^)>"};

            Random rand = new Random();

            int counter = 0;
            for(User username : users){


                int randLimit = 25;
                int randNum = rand.nextInt(randLimit);

                String author = event.getMessageAuthor().getDisplayName();
                String receiver = users.get(counter).getDisplayName(event.getServer().get());

                if(author.equals(receiver)) {
                    event.getChannel().sendMessage(author + " hugs themselves <3");
                } else {
                    event.getChannel().sendMessage(author + " " + hugs[randNum] + " " + receiver);
                }
                counter++;
            }


        }
    }
}
