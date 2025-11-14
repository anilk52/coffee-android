package com.example.coffee.ai;

/**
 * MİLO'nun her turdaki cevabını temsil eder.
 * - answer: ekranda gösterilecek metin
 * - expectsReply: MİLO kullanıcıdan cevap bekliyor mu (yeni soru sorduysa true)
 * - state: güncellenmiş sohbet durumu
 */
public class MiloReply {

    private final String answer;
    private final boolean expectsReply;
    private final MiloConversationState state;

    public MiloReply(String answer, boolean expectsReply, MiloConversationState state) {
        this.answer = answer;
        this.expectsReply = expectsReply;
        this.state = state;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isExpectsReply() {
        return expectsReply;
    }

    public MiloConversationState getState() {
        return state;
    }
}