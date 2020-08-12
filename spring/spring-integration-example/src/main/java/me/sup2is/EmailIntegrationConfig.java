package me.sup2is;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mail.ImapIdleChannelAdapter;
import org.springframework.integration.mail.ImapMailReceiver;
import org.springframework.messaging.MessageChannel;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailIntegrationConfig {

    @Bean
    public MessageChannel emailInChannel() {
        return new DirectChannel();
    }

    public Properties mailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.imap.ssl", "true");
        return properties;
    }

    @Bean
    public ImapIdleChannelAdapter imapIdleChannelAdapter(MessageChannel emailInChannel) {
        ImapMailReceiver imapMailReceiver = new ImapMailReceiver(createImapUrl());
        imapMailReceiver.setJavaMailProperties(mailProperties());
        imapMailReceiver.setShouldMarkMessagesAsRead(false);
        imapMailReceiver.setShouldDeleteMessages(false);
        imapMailReceiver.afterPropertiesSet();
        ImapIdleChannelAdapter imapIdleChannelAdapter = new ImapIdleChannelAdapter(imapMailReceiver);
        imapIdleChannelAdapter.setAutoStartup(true);
        imapIdleChannelAdapter.setOutputChannel(emailInChannel);
        imapIdleChannelAdapter.afterPropertiesSet();
        return imapIdleChannelAdapter;
    }

    @ServiceActivator(inputChannel = "emailInChannel")
    public void handleMessage(MimeMessage message) throws IOException, MessagingException {
        System.out.println("### Message Received!!!");
        System.out.println("### " + message.getSubject());
        System.out.println("### " + message.getFrom()[0]);
        System.out.println("### " + message.getContent().toString());
    }

    private String createImapUrl() {
        return "imaps://<user-email>:<password>@imap.gmail.com:993/inbox";
    }

}
