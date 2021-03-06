package biz.advancedcalendar.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import biz.advancedcalendar.greendao.Contact;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table CONTACT.
*/
public class ContactDao extends AbstractDao<Contact, Long> {

    public static final String TABLENAME = "CONTACT";

    /**
     * Properties of entity Contact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property LocalPhotoPath = new Property(1, String.class, "LocalPhotoPath", false, "LOCAL_PHOTO_PATH");
        public final static Property LocalCreateDateTime = new Property(2, long.class, "LocalCreateDateTime", false, "LOCAL_CREATE_DATE_TIME");
        public final static Property LocalChangeDateTime = new Property(3, long.class, "LocalChangeDateTime", false, "LOCAL_CHANGE_DATE_TIME");
        public final static Property SyncStatus = new Property(4, Byte.class, "SyncStatus", false, "SYNC_STATUS");
        public final static Property ServerId = new Property(5, Long.class, "ServerId", false, "SERVER_ID");
        public final static Property LastMod = new Property(6, Long.class, "LastMod", false, "LAST_MOD");
        public final static Property Created = new Property(7, Long.class, "Created", false, "CREATED");
        public final static Property UserName = new Property(8, String.class, "UserName", false, "USER_NAME");
        public final static Property ContactName = new Property(9, String.class, "ContactName", false, "CONTACT_NAME");
        public final static Property Description = new Property(10, String.class, "Description", false, "DESCRIPTION");
        public final static Property Photo = new Property(11, String.class, "Photo", false, "PHOTO");
        public final static Property SortOrder = new Property(12, Integer.class, "SortOrder", false, "SORT_ORDER");
        public final static Property Deleted = new Property(13, boolean.class, "Deleted", false, "DELETED");
        public final static Property BirthDay = new Property(14, Byte.class, "BirthDay", false, "BIRTH_DAY");
        public final static Property BirthMonth = new Property(15, Byte.class, "BirthMonth", false, "BIRTH_MONTH");
        public final static Property BirthYear = new Property(16, Short.class, "BirthYear", false, "BIRTH_YEAR");
        public final static Property CorpStatus = new Property(17, Byte.class, "CorpStatus", false, "CORP_STATUS");
    };

    private DaoSession daoSession;


    public ContactDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'CONTACT' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'LOCAL_PHOTO_PATH' TEXT," + // 1: LocalPhotoPath
                "'LOCAL_CREATE_DATE_TIME' INTEGER NOT NULL ," + // 2: LocalCreateDateTime
                "'LOCAL_CHANGE_DATE_TIME' INTEGER NOT NULL ," + // 3: LocalChangeDateTime
                "'SYNC_STATUS' INTEGER," + // 4: SyncStatus
                "'SERVER_ID' INTEGER," + // 5: ServerId
                "'LAST_MOD' INTEGER," + // 6: LastMod
                "'CREATED' INTEGER," + // 7: Created
                "'USER_NAME' TEXT," + // 8: UserName
                "'CONTACT_NAME' TEXT," + // 9: ContactName
                "'DESCRIPTION' TEXT," + // 10: Description
                "'PHOTO' TEXT," + // 11: Photo
                "'SORT_ORDER' INTEGER," + // 12: SortOrder
                "'DELETED' INTEGER NOT NULL ," + // 13: Deleted
                "'BIRTH_DAY' INTEGER," + // 14: BirthDay
                "'BIRTH_MONTH' INTEGER," + // 15: BirthMonth
                "'BIRTH_YEAR' INTEGER," + // 16: BirthYear
                "'CORP_STATUS' INTEGER);"); // 17: CorpStatus
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'CONTACT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Contact entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String LocalPhotoPath = entity.getLocalPhotoPath();
        if (LocalPhotoPath != null) {
            stmt.bindString(2, LocalPhotoPath);
        }
        stmt.bindLong(3, entity.getLocalCreateDateTime());
        stmt.bindLong(4, entity.getLocalChangeDateTime());
 
        Byte SyncStatus = entity.getSyncStatus();
        if (SyncStatus != null) {
            stmt.bindLong(5, SyncStatus);
        }
 
        Long ServerId = entity.getServerId();
        if (ServerId != null) {
            stmt.bindLong(6, ServerId);
        }
 
        Long LastMod = entity.getLastMod();
        if (LastMod != null) {
            stmt.bindLong(7, LastMod);
        }
 
        Long Created = entity.getCreated();
        if (Created != null) {
            stmt.bindLong(8, Created);
        }
 
        String UserName = entity.getUserName();
        if (UserName != null) {
            stmt.bindString(9, UserName);
        }
 
        String ContactName = entity.getContactName();
        if (ContactName != null) {
            stmt.bindString(10, ContactName);
        }
 
        String Description = entity.getDescription();
        if (Description != null) {
            stmt.bindString(11, Description);
        }
 
        String Photo = entity.getPhoto();
        if (Photo != null) {
            stmt.bindString(12, Photo);
        }
 
        Integer SortOrder = entity.getSortOrder();
        if (SortOrder != null) {
            stmt.bindLong(13, SortOrder);
        }
        stmt.bindLong(14, entity.getDeleted() ? 1l: 0l);
 
        Byte BirthDay = entity.getBirthDay();
        if (BirthDay != null) {
            stmt.bindLong(15, BirthDay);
        }
 
        Byte BirthMonth = entity.getBirthMonth();
        if (BirthMonth != null) {
            stmt.bindLong(16, BirthMonth);
        }
 
        Short BirthYear = entity.getBirthYear();
        if (BirthYear != null) {
            stmt.bindLong(17, BirthYear);
        }
 
        Byte CorpStatus = entity.getCorpStatus();
        if (CorpStatus != null) {
            stmt.bindLong(18, CorpStatus);
        }
    }

    @Override
    protected void attachEntity(Contact entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Contact readEntity(Cursor cursor, int offset) {
        Contact entity = new Contact( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // LocalPhotoPath
            cursor.getLong(offset + 2), // LocalCreateDateTime
            cursor.getLong(offset + 3), // LocalChangeDateTime
            cursor.isNull(offset + 4) ? null : (byte) cursor.getShort(offset + 4), // SyncStatus
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // ServerId
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // LastMod
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // Created
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // UserName
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // ContactName
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // Description
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // Photo
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // SortOrder
            cursor.getShort(offset + 13) != 0, // Deleted
            cursor.isNull(offset + 14) ? null : (byte) cursor.getShort(offset + 14), // BirthDay
            cursor.isNull(offset + 15) ? null : (byte) cursor.getShort(offset + 15), // BirthMonth
            cursor.isNull(offset + 16) ? null : cursor.getShort(offset + 16), // BirthYear
            cursor.isNull(offset + 17) ? null : (byte) cursor.getShort(offset + 17) // CorpStatus
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Contact entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLocalPhotoPath(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLocalCreateDateTime(cursor.getLong(offset + 2));
        entity.setLocalChangeDateTime(cursor.getLong(offset + 3));
        entity.setSyncStatus(cursor.isNull(offset + 4) ? null : (byte) cursor.getShort(offset + 4));
        entity.setServerId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setLastMod(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setCreated(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setUserName(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setContactName(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setDescription(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPhoto(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setSortOrder(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setDeleted(cursor.getShort(offset + 13) != 0);
        entity.setBirthDay(cursor.isNull(offset + 14) ? null : (byte) cursor.getShort(offset + 14));
        entity.setBirthMonth(cursor.isNull(offset + 15) ? null : (byte) cursor.getShort(offset + 15));
        entity.setBirthYear(cursor.isNull(offset + 16) ? null : cursor.getShort(offset + 16));
        entity.setCorpStatus(cursor.isNull(offset + 17) ? null : (byte) cursor.getShort(offset + 17));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Contact entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Contact entity) {
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
