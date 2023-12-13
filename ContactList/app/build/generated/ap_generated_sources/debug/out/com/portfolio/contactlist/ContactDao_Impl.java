package com.portfolio.contactlist;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class ContactDao_Impl implements ContactDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfContact;

  private final SharedSQLiteStatement __preparedStmtOfDeleteContact;

  public ContactDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContact = new EntityInsertionAdapter<Contact>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `contact_list`(`contactId`,`contactName`,`contactPhone`,`contactEmail`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Contact value) {
        stmt.bindLong(1, value.getId());
        if (value.getContactName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContactName());
        }
        if (value.getContactPhone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getContactPhone());
        }
        if (value.getContactEmail() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContactEmail());
        }
      }
    };
    this.__preparedStmtOfDeleteContact = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM contact_list WHERE contactName = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertContact(Contact product) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfContact.insert(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteContact(String name) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteContact.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (name == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, name);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteContact.release(_stmt);
    }
  }

  @Override
  public List<Contact> findName(String name) {
    final String _sql = "SELECT * FROM contact_list WHERE contactName LIKE ('%'||?||'%') ORDER BY contactName";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("contactId");
      final int _cursorIndexOfContactName = _cursor.getColumnIndexOrThrow("contactName");
      final int _cursorIndexOfContactPhone = _cursor.getColumnIndexOrThrow("contactPhone");
      final int _cursorIndexOfContactEmail = _cursor.getColumnIndexOrThrow("contactEmail");
      final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Contact _item;
        final String _tmpContactName;
        _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
        final String _tmpContactPhone;
        _tmpContactPhone = _cursor.getString(_cursorIndexOfContactPhone);
        final String _tmpContactEmail;
        _tmpContactEmail = _cursor.getString(_cursorIndexOfContactEmail);
        _item = new Contact(_tmpContactName,_tmpContactPhone,_tmpContactEmail);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Contact> findPhone(String phone) {
    final String _sql = "SELECT * FROM contact_list WHERE contactPhone LIKE ('%'||?||'%') ORDER BY contactPhone";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phone == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phone);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("contactId");
      final int _cursorIndexOfContactName = _cursor.getColumnIndexOrThrow("contactName");
      final int _cursorIndexOfContactPhone = _cursor.getColumnIndexOrThrow("contactPhone");
      final int _cursorIndexOfContactEmail = _cursor.getColumnIndexOrThrow("contactEmail");
      final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Contact _item;
        final String _tmpContactName;
        _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
        final String _tmpContactPhone;
        _tmpContactPhone = _cursor.getString(_cursorIndexOfContactPhone);
        final String _tmpContactEmail;
        _tmpContactEmail = _cursor.getString(_cursorIndexOfContactEmail);
        _item = new Contact(_tmpContactName,_tmpContactPhone,_tmpContactEmail);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Contact> findEmail(String email) {
    final String _sql = "SELECT * FROM contact_list WHERE contactEmail LIKE ('%'||?||'%') ORDER BY contactEmail";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("contactId");
      final int _cursorIndexOfContactName = _cursor.getColumnIndexOrThrow("contactName");
      final int _cursorIndexOfContactPhone = _cursor.getColumnIndexOrThrow("contactPhone");
      final int _cursorIndexOfContactEmail = _cursor.getColumnIndexOrThrow("contactEmail");
      final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Contact _item;
        final String _tmpContactName;
        _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
        final String _tmpContactPhone;
        _tmpContactPhone = _cursor.getString(_cursorIndexOfContactPhone);
        final String _tmpContactEmail;
        _tmpContactEmail = _cursor.getString(_cursorIndexOfContactEmail);
        _item = new Contact(_tmpContactName,_tmpContactPhone,_tmpContactEmail);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Contact>> getAllContacts() {
    final String _sql = "SELECT * FROM contact_list ORDER BY contactName";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Contact>>() {
      private Observer _observer;

      @Override
      protected List<Contact> compute() {
        if (_observer == null) {
          _observer = new Observer("contact_list") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("contactId");
          final int _cursorIndexOfContactName = _cursor.getColumnIndexOrThrow("contactName");
          final int _cursorIndexOfContactPhone = _cursor.getColumnIndexOrThrow("contactPhone");
          final int _cursorIndexOfContactEmail = _cursor.getColumnIndexOrThrow("contactEmail");
          final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Contact _item;
            final String _tmpContactName;
            _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            final String _tmpContactPhone;
            _tmpContactPhone = _cursor.getString(_cursorIndexOfContactPhone);
            final String _tmpContactEmail;
            _tmpContactEmail = _cursor.getString(_cursorIndexOfContactEmail);
            _item = new Contact(_tmpContactName,_tmpContactPhone,_tmpContactEmail);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
