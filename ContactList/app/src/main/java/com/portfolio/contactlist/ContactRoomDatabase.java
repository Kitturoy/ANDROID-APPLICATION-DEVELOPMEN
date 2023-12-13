package com.portfolio.contactlist;

import android.content.Context;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

//exportSchema = false to address build warnings
@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactRoomDatabase extends RoomDatabase
{
    public abstract ContactDao contactDao();
    private static ContactRoomDatabase INSTANCE;

    static ContactRoomDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (ContactRoomDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ContactRoomDatabase.class, "contact_list").build();
                }
            }
        }
        return INSTANCE;
    }
}