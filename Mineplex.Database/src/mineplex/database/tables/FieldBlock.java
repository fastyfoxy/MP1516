/**
 * This class is generated by jOOQ
 */
package mineplex.database.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.2"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FieldBlock extends org.jooq.impl.TableImpl<mineplex.database.tables.records.FieldBlockRecord> implements java.io.Serializable, java.lang.Cloneable {

	private static final long serialVersionUID = 584309427;

	/**
	 * The reference instance of <code>Account.fieldBlock</code>
	 */
	public static final mineplex.database.tables.FieldBlock fieldBlock = new mineplex.database.tables.FieldBlock();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<mineplex.database.tables.records.FieldBlockRecord> getRecordType() {
		return mineplex.database.tables.records.FieldBlockRecord.class;
	}

	/**
	 * The column <code>Account.fieldBlock.id</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.Integer> id = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>Account.fieldBlock.server</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.String> server = createField("server", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>Account.fieldBlock.location</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.String> location = createField("location", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>Account.fieldBlock.blockId</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.Integer> blockId = createField("blockId", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>Account.fieldBlock.blockData</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.Byte> blockData = createField("blockData", org.jooq.impl.SQLDataType.TINYINT, this, "");

	/**
	 * The column <code>Account.fieldBlock.emptyId</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.Integer> emptyId = createField("emptyId", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>Account.fieldBlock.emptyData</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.Byte> emptyData = createField("emptyData", org.jooq.impl.SQLDataType.TINYINT, this, "");

	/**
	 * The column <code>Account.fieldBlock.stockMax</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.Integer> stockMax = createField("stockMax", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>Account.fieldBlock.stockRegenTime</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.Double> stockRegenTime = createField("stockRegenTime", org.jooq.impl.SQLDataType.DOUBLE, this, "");

	/**
	 * The column <code>Account.fieldBlock.loot</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.FieldBlockRecord, java.lang.String> loot = createField("loot", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * Create a <code>Account.fieldBlock</code> table reference
	 */
	public FieldBlock() {
		this("fieldBlock", null);
	}

	/**
	 * Create an aliased <code>Account.fieldBlock</code> table reference
	 */
	public FieldBlock(java.lang.String alias) {
		this(alias, mineplex.database.tables.FieldBlock.fieldBlock);
	}

	private FieldBlock(java.lang.String alias, org.jooq.Table<mineplex.database.tables.records.FieldBlockRecord> aliased) {
		this(alias, aliased, null);
	}

	private FieldBlock(java.lang.String alias, org.jooq.Table<mineplex.database.tables.records.FieldBlockRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, mineplex.database.Account.Account, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<mineplex.database.tables.records.FieldBlockRecord, java.lang.Integer> getIdentity() {
		return mineplex.database.Keys.IDENTITY_fieldBlock;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<mineplex.database.tables.records.FieldBlockRecord> getPrimaryKey() {
		return mineplex.database.Keys.KEY_fieldBlock_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<mineplex.database.tables.records.FieldBlockRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<mineplex.database.tables.records.FieldBlockRecord>>asList(mineplex.database.Keys.KEY_fieldBlock_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public mineplex.database.tables.FieldBlock as(java.lang.String alias) {
		return new mineplex.database.tables.FieldBlock(alias, this);
	}

	/**
	 * Rename this table
	 */
	public mineplex.database.tables.FieldBlock rename(java.lang.String name) {
		return new mineplex.database.tables.FieldBlock(name, null);
	}
}
