/*
 * Copyright (C) 2015 Naman Dwivedi
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 */

package com.naman14.timber.dataloaders;

import android.content.Context;

import com.naman14.timber.models.Song;

import java.util.ArrayList;
import java.util.List;


public class QueueLoader {


    public static List<Song> getQueueSongs(Context context) {

        final ArrayList<Song> mSongList = new ArrayList<>();
        NowPlayingCursor cursor = new NowPlayingCursor(context);

        if (cursor.moveToFirst()) {
            do {

                final long id = cursor.getLong(0);

                final String songName = cursor.getString(1);

                final String artist = cursor.getString(2);

                final long albumId = cursor.getLong(3);

                final String album = cursor.getString(4);

                final int duration = cursor.getInt(5);

                final long artistid = cursor.getInt(7);

                final int tracknumber = cursor.getInt(6);

                final Song song = new Song(id, albumId, artistid, songName, artist, album, duration, tracknumber);

                mSongList.add(song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mSongList;
    }

}
