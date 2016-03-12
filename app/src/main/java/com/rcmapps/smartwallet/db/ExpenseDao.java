package com.rcmapps.smartwallet.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.rcmapps.smartwallet.db.Expense;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "EXPENSE".
*/
public class ExpenseDao extends AbstractDao<Expense, Long> {

    public static final String TABLENAME = "EXPENSE";

    /**
     * Properties of entity Expense.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Amount = new Property(1, Integer.class, "amount", false, "AMOUNT");
        public final static Property Reason = new Property(2, String.class, "reason", false, "REASON");
        public final static Property Date = new Property(3, java.util.Date.class, "date", false, "DATE");
    };


    public ExpenseDao(DaoConfig config) {
        super(config);
    }
    
    public ExpenseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"EXPENSE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"AMOUNT\" INTEGER," + // 1: amount
                "\"REASON\" TEXT," + // 2: reason
                "\"DATE\" INTEGER);"); // 3: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"EXPENSE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Expense entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer amount = entity.getAmount();
        if (amount != null) {
            stmt.bindLong(2, amount);
        }
 
        String reason = entity.getReason();
        if (reason != null) {
            stmt.bindString(3, reason);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(4, date.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Expense readEntity(Cursor cursor, int offset) {
        Expense entity = new Expense( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // amount
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // reason
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)) // date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Expense entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAmount(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setReason(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDate(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Expense entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Expense entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
