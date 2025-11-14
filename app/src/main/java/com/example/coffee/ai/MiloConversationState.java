package com.example.coffee.ai;

/**
 * MİLO'nun sohbet sırasında tuttuğu durum bilgisi.
 * - Hangi modda (öneri / sorun çözme / yok)
 * - Kaçıncı adımda
 * - Kullanıcının kahve tercihleri
 */
public class MiloConversationState {

    public enum Mode {
        NONE,
        RECOMMENDATION, // "ne içsem" modu
        TROUBLE         // sorun çözme (şimdilik tek seferlik)
    }

    public enum PrefMilk { UNKNOWN, MILKY, BLACK }          // sütlü mü sade mi
    public enum PrefStrength { UNKNOWN, LIGHT, STRONG }     // hafif mi sert mi
    public enum PrefTemp { UNKNOWN, HOT, COLD }             // sıcak mı buzlu mu
    public enum PrefEffort { UNKNOWN, EASY, DONT_CARE }     // pratik mi fark etmez mi

    public Mode mode = Mode.NONE;
    public int step = 0;

    public PrefMilk milkPref = PrefMilk.UNKNOWN;
    public PrefStrength strengthPref = PrefStrength.UNKNOWN;
    public PrefTemp tempPref = PrefTemp.UNKNOWN;
    public PrefEffort effortPref = PrefEffort.UNKNOWN;

    public MiloConversationState copy() {
        MiloConversationState s = new MiloConversationState();
        s.mode = this.mode;
        s.step = this.step;
        s.milkPref = this.milkPref;
        s.strengthPref = this.strengthPref;
        s.tempPref = this.tempPref;
        s.effortPref = this.effortPref;
        return s;
    }
}