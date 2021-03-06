package biz.advancedcalendar.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import biz.advancedcalendar.greendao.LabelContact;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table LABEL_CONTACT.
*/
public class LabelContactDao extends AbstractDao<LabelContact, Long> {

    public static final String TABLENAME = "LABEL_CONTACT";

    /**
     * Properties of entity LabelContact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property LabelId = new Property(1, Long.class, "LabelId", false, "LABEL_ID");
        public final static Property ContactId = new Property(2, Long.class, "ContactId", false, "CONTACT_ID");
        public final static Property IsVirtual = new Property(3, Boolean.class, "IsVirtual", false, "IS_VIRTUAL");
    };

    private DaoSession daoSession;

    private Query<LabelContact> label_LabelContactListQuery;
    private Query<LabelContact> contact_LabelContactListQuery;

    public LabelContactDao(DaoConfig config) {
        super(config);
    }
    
    public LabelContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'LABEL_CONTACT' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'LABEL_ID' INTEGER," + // 1: LabelId
                "'CONTACT_ID' INTEGER," + // 2: ContactId
                "'IS_VIRTUAL' INTEGER);"); // 3: IsVirtual
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_LABEL_CONTACT_LABEL_ID_CONTACT_ID ON LABEL_CONTACT" +
                " (LABEL_ID,CONTACT_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'LABEL_CONTACT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, LabelContact entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long LabelId = entity.getLabelId();
        if (LabelId != null) {
            stmt.bindLong(2, LabelId);
        }
 
        Long ContactId = entity.getContactId();
        if (ContactId != null) {
            stmt.bindLong(3, ContactId);
        }
 
        Boolean IsVirtual = entity.getIsVirtual();
        if (IsVirtual != null) {
            stmt.bindLong(4, IsVirtual ? 1l: 0l);
        }
    }

    @Override
    protected void attachEntity(LabelContact entity) {
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
    public LabelContact readEntity(Cursor cursor, int offset) {
        LabelContact entity = new LabelContact( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // LabelId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // ContactId
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0 // IsVirtual
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, LabelContact entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLabelId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setContactId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setIsVirtual(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(LabelContact entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(LabelContact entity) {
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
    
    /** Internal query to resolve the "labelContactList" to-many relationship of Label. */
    public List<LabelContact> _queryLabel_LabelContactList(Long LabelId) {
        synchronized (this) {
            if (label_LabelContactListQuery == null) {
                QueryBuilder<LabelContact> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.LabelId.eq(null));
                label_LabelContactListQuery = queryBuilder.build();
            }
        }
        Query<LabelContact> query = label_LabelContactListQuery.forCurrentThread();
        query.setParameter(0, LabelId);
        return query.list();
    }

    /** Internal query to resolve the "labelContactList" to-many relationship of Contact. */
    public List<LabelContact> _queryContact_LabelContactList(Long ContactId) {
        synchronized (this) {
            if (contact_LabelContactListQuery == null) {
                QueryBuilder<LabelContact> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ContactId.eq(null));
                contact_LabelContactListQuery = queryBuilder.build();
            }
        }
        Query<LabelContact> query = contact_LabelContactListQuery.forCurrentThread();
        query.setParameter(0, ContactId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getLabelDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getContactDao().getAllColumns());
            builder.append(" FROM LABEL_CONTACT T");
            builder.append(" LEFT JOIN LABEL T0 ON T.'LABEL_ID'=T0.'_id'");
            builder.append(" LEFT JOIN CONTACT T1 ON T.'CONTACT_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected LabelContact loadCurrentDeep(Cursor cursor, boolean lock) {
        LabelContact entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Label label = loadCurrentOther(daoSession.getLabelDao(), cursor, offset);
        entity.setLabel(label);
        offset += daoSession.getLabelDao().getAllColumns().length;

        Contact contact = loadCurrentOther(daoSession.getContactDao(), cursor, offset);
        entity.setContact(contact);

        return entity;    
    }

    public LabelContact loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<LabelContact> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<LabelContact> list = new ArrayList<LabelContact>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<LabelContact> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<LabelContact> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
