package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class PersonRealmProxy extends com.example.mohammadghasemi.test.Person
    implements RealmObjectProxy, PersonRealmProxyInterface {

    static final class PersonColumnInfo extends ColumnInfo {
        long idIndex;
        long fuckingIDKIndex;

        PersonColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Person");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.fuckingIDKIndex = addColumnDetails("fuckingIDK", objectSchemaInfo);
        }

        PersonColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PersonColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PersonColumnInfo src = (PersonColumnInfo) rawSrc;
            final PersonColumnInfo dst = (PersonColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.fuckingIDKIndex = src.fuckingIDKIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("fuckingIDK");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private PersonColumnInfo columnInfo;
    private ProxyState<com.example.mohammadghasemi.test.Person> proxyState;

    PersonRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PersonColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.mohammadghasemi.test.Person>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fuckingIDK() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fuckingIDKIndex);
    }

    @Override
    public void realmSet$fuckingIDK(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'fuckingIDK' to null.");
            }
            row.getTable().setString(columnInfo.fuckingIDKIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'fuckingIDK' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.fuckingIDKIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Person");
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fuckingIDK", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PersonColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PersonColumnInfo(schemaInfo);
    }

    public static String getTableName() {
        return "class_Person";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.mohammadghasemi.test.Person createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.mohammadghasemi.test.Person obj = realm.createObjectInternal(com.example.mohammadghasemi.test.Person.class, true, excludeFields);

        final PersonRealmProxyInterface objProxy = (PersonRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("fuckingIDK")) {
            if (json.isNull("fuckingIDK")) {
                objProxy.realmSet$fuckingIDK(null);
            } else {
                objProxy.realmSet$fuckingIDK((String) json.getString("fuckingIDK"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.mohammadghasemi.test.Person createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.mohammadghasemi.test.Person obj = new com.example.mohammadghasemi.test.Person();
        final PersonRealmProxyInterface objProxy = (PersonRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("fuckingIDK")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fuckingIDK((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fuckingIDK(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.mohammadghasemi.test.Person copyOrUpdate(Realm realm, com.example.mohammadghasemi.test.Person object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.mohammadghasemi.test.Person) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.mohammadghasemi.test.Person copy(Realm realm, com.example.mohammadghasemi.test.Person newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.mohammadghasemi.test.Person) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.mohammadghasemi.test.Person realmObject = realm.createObjectInternal(com.example.mohammadghasemi.test.Person.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        PersonRealmProxyInterface realmObjectSource = (PersonRealmProxyInterface) newObject;
        PersonRealmProxyInterface realmObjectCopy = (PersonRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$fuckingIDK(realmObjectSource.realmGet$fuckingIDK());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.mohammadghasemi.test.Person object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.mohammadghasemi.test.Person.class);
        long tableNativePtr = table.getNativePtr();
        PersonColumnInfo columnInfo = (PersonColumnInfo) realm.getSchema().getColumnInfo(com.example.mohammadghasemi.test.Person.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((PersonRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$fuckingIDK = ((PersonRealmProxyInterface) object).realmGet$fuckingIDK();
        if (realmGet$fuckingIDK != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fuckingIDKIndex, rowIndex, realmGet$fuckingIDK, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.mohammadghasemi.test.Person.class);
        long tableNativePtr = table.getNativePtr();
        PersonColumnInfo columnInfo = (PersonColumnInfo) realm.getSchema().getColumnInfo(com.example.mohammadghasemi.test.Person.class);
        com.example.mohammadghasemi.test.Person object = null;
        while (objects.hasNext()) {
            object = (com.example.mohammadghasemi.test.Person) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((PersonRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$fuckingIDK = ((PersonRealmProxyInterface) object).realmGet$fuckingIDK();
            if (realmGet$fuckingIDK != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fuckingIDKIndex, rowIndex, realmGet$fuckingIDK, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.mohammadghasemi.test.Person object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.mohammadghasemi.test.Person.class);
        long tableNativePtr = table.getNativePtr();
        PersonColumnInfo columnInfo = (PersonColumnInfo) realm.getSchema().getColumnInfo(com.example.mohammadghasemi.test.Person.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((PersonRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$fuckingIDK = ((PersonRealmProxyInterface) object).realmGet$fuckingIDK();
        if (realmGet$fuckingIDK != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fuckingIDKIndex, rowIndex, realmGet$fuckingIDK, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fuckingIDKIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.mohammadghasemi.test.Person.class);
        long tableNativePtr = table.getNativePtr();
        PersonColumnInfo columnInfo = (PersonColumnInfo) realm.getSchema().getColumnInfo(com.example.mohammadghasemi.test.Person.class);
        com.example.mohammadghasemi.test.Person object = null;
        while (objects.hasNext()) {
            object = (com.example.mohammadghasemi.test.Person) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((PersonRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$fuckingIDK = ((PersonRealmProxyInterface) object).realmGet$fuckingIDK();
            if (realmGet$fuckingIDK != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fuckingIDKIndex, rowIndex, realmGet$fuckingIDK, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fuckingIDKIndex, rowIndex, false);
            }
        }
    }

    public static com.example.mohammadghasemi.test.Person createDetachedCopy(com.example.mohammadghasemi.test.Person realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.mohammadghasemi.test.Person unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.mohammadghasemi.test.Person();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.mohammadghasemi.test.Person) cachedObject.object;
            }
            unmanagedObject = (com.example.mohammadghasemi.test.Person) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        PersonRealmProxyInterface unmanagedCopy = (PersonRealmProxyInterface) unmanagedObject;
        PersonRealmProxyInterface realmSource = (PersonRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$fuckingIDK(realmSource.realmGet$fuckingIDK());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Person = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fuckingIDK:");
        stringBuilder.append(realmGet$fuckingIDK());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonRealmProxy aPerson = (PersonRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPerson.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPerson.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPerson.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
