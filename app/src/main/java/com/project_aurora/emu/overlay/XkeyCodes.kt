/* Copyright (c) 2024 Projeto Aurora App
   Copyright (c) 2024  José G.
   
   Todos os direitos reservados.
   Sob os termos da licença MIT.
*/

package com.project_aurora.emu.overlay

import android.view.KeyEvent.*

object XkeyCodes {
    // TODO: define XkeyCodes list of
    const val DPAD_UP : Int = 19; // ANDROID_KEYCODE_DPAD_UP
    const val DPAD_DOWN : Int = 20; // ANDROID_KEYCODE_DPAD_DOWN
    const val DPAD_LEFT : Int = 21; // ANDROID_KEYCODE_DPAD_LEFT
    const val DPAD_RIGHT : Int = 22; // ANDROID_KEYCODE_DPAD_RIGHT
    const val BACK : Int = 4; // ANDROID_KEYCODE_BACK
    const val KEY_0 : Int = 7; // ANDROID_KEYCODE_0
    const val KEY_1 : Int = 8; // ANDROID_KEYCODE_1
    const val KEY_2 : Int = 9; // ANDROID_KEYCODE_2
    const val KEY_3 : Int = 10; // ANDROID_KEYCODE_3
    const val KEY_4 : Int = 11; // ANDROID_KEYCODE_4
    const val KEY_5 : Int = 12; // ANDROID_KEYCODE_5
    const val KEY_6 : Int = 13; // ANDROID_KEYCODE_6
    const val KEY_7 : Int = 14; // ANDROID_KEYCODE_7
    const val KEY_8 : Int = 15; // ANDROID_KEYCODE_8
    const val KEY_9 : Int = 16; // ANDROID_KEYCODE_9
    const val STAR : Int = 17; // ANDROID_KEYCODE_STAR
    const val VOLUME_UP : Int = 24; // ANDROID_KEYCODE_VOLUME_UP
    const val VOLUME_DOWN : Int = 25; // ANDROID_KEYCODE_VOLUME_DOWN
    const val POWER : Int = 26; // ANDROID_KEYCODE_POWER
    const val CAMERA : Int = 27; // ANDROID_KEYCODE_CAMERA
    const val CLEAR : Int = 28; // ANDROID_KEYCODE_CLEAR
    const val A : Int = 29; // ANDROID_KEYCODE_A
    const val B : Int = 30; // ANDROID_KEYCODE_B
    const val C : Int = 31; // ANDROID_KEYCODE_C
    const val D : Int = 32; // ANDROID_KEYCODE_D
    const val E : Int = 33; // ANDROID_KEYCODE_E
    const val F : Int = 34; // ANDROID_KEYCODE_F
    const val G : Int = 35; // ANDROID_KEYCODE_G
    const val H : Int = 36; // ANDROID_KEYCODE_H
    const val I : Int = 37; // ANDROID_KEYCODE_I
    const val J : Int = 38; // ANDROID_KEYCODE_J
    const val K : Int = 39; // ANDROID_KEYCODE_K
    const val L : Int = 40; // ANDROID_KEYCODE_L
    const val M : Int = 41; // ANDROID_KEYCODE_M
    const val N : Int = 42; // ANDROID_KEYCODE_N
    const val O : Int = 43; // ANDROID_KEYCODE_O
    const val P : Int = 44; // ANDROID_KEYCODE_P
    const val Q : Int = 45; // ANDROID_KEYCODE_Q
    const val R : Int = 46; // ANDROID_KEYCODE_R
    const val S : Int = 47; // ANDROID_KEYCODE_S
    const val T : Int = 48; // ANDROID_KEYCODE_T
    const val U : Int = 49; // ANDROID_KEYCODE_U
    const val V : Int = 50; // ANDROID_KEYCODE_V
    const val W : Int = 51; // ANDROID_KEYCODE_W
    const val X : Int = 52; // ANDROID_KEYCODE_X
    const val Y : Int = 53; // ANDROID_KEYCODE_Y
    const val Z : Int = 54; // ANDROID_KEYCODE_Z
    const val COMMA : Int = 55; // ANDROID_KEYCODE_COMMA
    const val PERIOD : Int = 56; // ANDROID_KEYCODE_PERIOD
    const val ALT_LEFT : Int = 57; // ANDROID_KEYCODE_ALT_LEFT
    const val ALT_RIGHT : Int = 58; // ANDROID_KEYCODE_ALT_RIGHT
    const val SHIFT_LEFT : Int = 59; // ANDROID_KEYCODE_SHIFT_LEFT
    const val SHIFT_RIGHT : Int = 60; // ANDROID_KEYCODE_SHIFT_RIGHT
    const val TAB : Int = 61; // ANDROID_KEYCODE_TAB
    const val SPACE : Int = 62; // ANDROID_KEYCODE_SPACE
    const val EXPLORER : Int = 64; // ANDROID_KEYCODE_EXPLORER
    const val ENVELOPE : Int = 65; // ANDROID_KEYCODE_ENVELOPE
    const val ENTER : Int = 66; // ANDROID_KEYCODE_ENTER
    const val DEL : Int = 67; // ANDROID_KEYCODE_DEL
    const val GRAVE : Int = 68; // ANDROID_KEYCODE_GRAVE
    const val MINUS : Int = 69; // ANDROID_KEYCODE_MINUS
    const val EQUALS : Int = 70; // ANDROID_KEYCODE_EQUALS
    const val LEFT_BRACKET : Int = 71; // ANDROID_KEYCODE_LEFT_BRACKET
    const val RIGHT_BRACKET : Int = 72; // ANDROID_KEYCODE_RIGHT_BRACKET
    const val BACKSLASH : Int = 73; // ANDROID_KEYCODE_BACKSLASH
    const val SEMICOLON : Int = 74; // ANDROID_KEYCODE_SEMICOLON
    const val APOSTROPHE : Int = 75; // ANDROID_KEYCODE_APOSTROPHE
    const val SLASH : Int = 76; // ANDROID_KEYCODE_SLASH
    const val PLUS : Int = 81; // ANDROID_KEYCODE_PLUS
    const val MENU : Int = 82; // ANDROID_KEYCODE_MENU
    const val SEARCH : Int = 84; // ANDROID_KEYCODE_SEARCH
    const val MEDIA_PLAY_PAUSE : Int = 85; // ANDROID_KEYCODE_MEDIA_PLAY_PAUSE
    const val MEDIA_STOP : Int = 86; // ANDROID_KEYCODE_MEDIA_STOP
    const val MEDIA_NEXT : Int = 87; // ANDROID_KEYCODE_MEDIA_NEXT
    const val MEDIA_PREVIOUS : Int = 88; // ANDROID_KEYCODE_MEDIA_PREVIOUS
    const val MEDIA_REWIND : Int = 89; // ANDROID_KEYCODE_MEDIA_REWIND
    const val MEDIA_FAST_FORWARD : Int = 90; // ANDROID_KEYCODE_MEDIA_FAST_FORWARD
    const val MUTE : Int = 91; // ANDROID_KEYCODE_MUTE
    const val PAGE_UP : Int = 92; // ANDROID_KEYCODE_PAGE_UP
    const val PAGE_DOWN : Int = 93; // ANDROID_KEYCODE_PAGE_DOWN
    const val ESCAPE : Int = 111; // ANDROID_KEYCODE_ESCAPE
    const val FORWARD_DEL : Int = 112; // ANDROID_KEYCODE_FORWARD_DEL
    const val CTRL_LEFT : Int = 113; // ANDROID_KEYCODE_CTRL_LEFT
    const val CTRL_RIGHT : Int = 114; // ANDROID_KEYCODE_CTRL_RIGHT
    const val CAPS_LOCK : Int = 115; // ANDROID_KEYCODE_CAPS_LOCK
    const val SCROLL_LOCK : Int = 116; // ANDROID_KEYCODE_SCROLL_LOCK
    const val META_LEFT : Int = 117; // ANDROID_KEYCODE_META_LEFT
    const val META_RIGHT : Int = 118; // ANDROID_KEYCODE_META_RIGHT
    const val SYSRQ : Int = 120; // ANDROID_KEYCODE_SYSRQ
    const val BREAK : Int = 121; // ANDROID_KEYCODE_BREAK
    const val MOVE_HOME : Int = 122; // ANDROID_KEYCODE_MOVE_HOME
    const val MOVE_END : Int = 123; // ANDROID_KEYCODE_MOVE_END
    const val INSERT : Int = 124; // ANDROID_KEYCODE_INSERT
    const val FORWARD : Int = 125; // ANDROID_KEYCODE_FORWARD
    const val MEDIA_PLAY : Int = 126; // ANDROID_KEYCODE_MEDIA_PLAY
    const val MEDIA_PAUSE : Int = 127; // ANDROID_KEYCODE_MEDIA_PAUSE
    const val MEDIA_CLOSE : Int = 128; // ANDROID_KEYCODE_MEDIA_CLOSE
    const val MEDIA_EJECT : Int = 129; // ANDROID_KEYCODE_MEDIA_EJECT
    const val MEDIA_RECORD : Int = 130; // ANDROID_KEYCODE_MEDIA_RECORD
    const val F1 : Int = 131; // ANDROID_KEYCODE_F1
    const val F2 : Int = 132; // ANDROID_KEYCODE_F2
    const val F3 : Int = 133; // ANDROID_KEYCODE_F3
    const val F4 : Int = 134; // ANDROID_KEYCODE_F4
    const val F5 : Int = 135; // ANDROID_KEYCODE_F5
    const val F6 : Int = 136; // ANDROID_KEYCODE_F6
    const val F7 : Int = 137; // ANDROID_KEYCODE_F7
    const val F8 : Int = 138; // ANDROID_KEYCODE_F8
    const val F9 : Int = 139; // ANDROID_KEYCODE_F9
    const val F10 : Int = 140; // ANDROID_KEYCODE_F10
    const val F11 : Int = 141; // ANDROID_KEYCODE_F11
    const val F12 : Int = 142; // ANDROID_KEYCODE_F12
    const val NUM_LOCK : Int = 143; // ANDROID_KEYCODE_NUM_LOCK
    const val NUMPAD_0 : Int = 144; // ANDROID_KEYCODE_NUMPAD_0
    const val NUMPAD_1 : Int = 145; // ANDROID_KEYCODE_NUMPAD_1
    const val NUMPAD_2 : Int = 146; // ANDROID_KEYCODE_NUMPAD_2
    const val NUMPAD_3 : Int = 147; // ANDROID_KEYCODE_NUMPAD_3
    const val NUMPAD_4 : Int = 148; // ANDROID_KEYCODE_NUMPAD_4
    const val NUMPAD_5 : Int = 149; // ANDROID_KEYCODE_NUMPAD_5
    const val NUMPAD_6 : Int = 150; // ANDROID_KEYCODE_NUMPAD_6
    const val NUMPAD_7 : Int = 151; // ANDROID_KEYCODE_NUMPAD_7
    const val NUMPAD_8 : Int = 152; // ANDROID_KEYCODE_NUMPAD_8
    const val NUMPAD_9 : Int = 153; // ANDROID_KEYCODE_NUMPAD_9
    const val NUMPAD_DIVIDE : Int = 154; // ANDROID_KEYCODE_NUMPAD_DIVIDE
    const val NUMPAD_MULTIPLY : Int = 155; // ANDROID_KEYCODE_NUMPAD_MULTIPLY
    const val NUMPAD_SUBTRACT : Int = 156; // ANDROID_KEYCODE_NUMPAD_SUBTRACT
    const val NUMPAD_ADD : Int = 157; // ANDROID_KEYCODE_NUMPAD_ADD
    const val NUMPAD_DOT : Int = 158; // ANDROID_KEYCODE_NUMPAD_DOT
    const val NUMPAD_COMMA : Int = 159; // ANDROID_KEYCODE_NUMPAD_COMMA
    const val NUMPAD_ENTER : Int = 160; // ANDROID_KEYCODE_NUMPAD_ENTER
    const val NUMPAD_EQUALS : Int = 161; // ANDROID_KEYCODE_NUMPAD_EQUALS
    const val NUMPAD_LEFT_PAREN : Int = 162; // ANDROID_KEYCODE_NUMPAD_LEFT_PAREN
    const val NUMPAD_RIGHT_PAREN : Int = 163; // ANDROID_KEYCODE_NUMPAD_RIGHT_PAREN
    const val VOLUME_MUTE : Int = 164; // ANDROID_KEYCODE_VOLUME_MUTE
    const val INFO : Int = 165; // ANDROID_KEYCODE_INFO
    const val CHANNEL_UP : Int = 166; // ANDROID_KEYCODE_CHANNEL_UP
    const val CHANNEL_DOWN : Int = 167; // ANDROID_KEYCODE_CHANNEL_DOWN
    const val ZOOM_IN : Int = 168; // ANDROID_KEYCODE_ZOOM_IN
    const val ZOOM_OUT : Int = 169; // ANDROID_KEYCODE_ZOOM_OUT
    const val TV : Int = 170; // ANDROID_KEYCODE_TV
    const val CALENDAR : Int = 208; // ANDROID_KEYCODE_CALENDAR
    const val CALCULATOR : Int = 210; // ANDROID_KEYCODE_CALCULATOR
    
    
}
