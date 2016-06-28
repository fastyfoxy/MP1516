/**
 * This class is generated by jOOQ
 */
package mineplex.database.tables.records;

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
public class NpcsRecord extends org.jooq.impl.UpdatableRecordImpl<mineplex.database.tables.records.NpcsRecord> implements java.io.Serializable, java.lang.Cloneable, org.jooq.Record19<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Integer> {

	private static final long serialVersionUID = -112578515;

	/**
	 * Setter for <code>Account.npcs.id</code>.
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>Account.npcs.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>Account.npcs.server</code>.
	 */
	public void setServer(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>Account.npcs.server</code>.
	 */
	public java.lang.String getServer() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>Account.npcs.name</code>.
	 */
	public void setName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>Account.npcs.name</code>.
	 */
	public java.lang.String getName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>Account.npcs.world</code>.
	 */
	public void setWorld(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>Account.npcs.world</code>.
	 */
	public java.lang.String getWorld() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>Account.npcs.x</code>.
	 */
	public void setX(java.lang.Double value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>Account.npcs.x</code>.
	 */
	public java.lang.Double getX() {
		return (java.lang.Double) getValue(4);
	}

	/**
	 * Setter for <code>Account.npcs.y</code>.
	 */
	public void setY(java.lang.Double value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>Account.npcs.y</code>.
	 */
	public java.lang.Double getY() {
		return (java.lang.Double) getValue(5);
	}

	/**
	 * Setter for <code>Account.npcs.z</code>.
	 */
	public void setZ(java.lang.Double value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>Account.npcs.z</code>.
	 */
	public java.lang.Double getZ() {
		return (java.lang.Double) getValue(6);
	}

	/**
	 * Setter for <code>Account.npcs.radius</code>.
	 */
	public void setRadius(java.lang.Double value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>Account.npcs.radius</code>.
	 */
	public java.lang.Double getRadius() {
		return (java.lang.Double) getValue(7);
	}

	/**
	 * Setter for <code>Account.npcs.entityType</code>.
	 */
	public void setEntityType(java.lang.String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>Account.npcs.entityType</code>.
	 */
	public java.lang.String getEntityType() {
		return (java.lang.String) getValue(8);
	}

	/**
	 * Setter for <code>Account.npcs.entityMeta</code>.
	 */
	public void setEntityMeta(java.lang.String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>Account.npcs.entityMeta</code>.
	 */
	public java.lang.String getEntityMeta() {
		return (java.lang.String) getValue(9);
	}

	/**
	 * Setter for <code>Account.npcs.adult</code>.
	 */
	public void setAdult(java.lang.Boolean value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>Account.npcs.adult</code>.
	 */
	public java.lang.Boolean getAdult() {
		return (java.lang.Boolean) getValue(10);
	}

	/**
	 * Setter for <code>Account.npcs.helmet</code>.
	 */
	public void setHelmet(java.lang.String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>Account.npcs.helmet</code>.
	 */
	public java.lang.String getHelmet() {
		return (java.lang.String) getValue(11);
	}

	/**
	 * Setter for <code>Account.npcs.chestplate</code>.
	 */
	public void setChestplate(java.lang.String value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>Account.npcs.chestplate</code>.
	 */
	public java.lang.String getChestplate() {
		return (java.lang.String) getValue(12);
	}

	/**
	 * Setter for <code>Account.npcs.leggings</code>.
	 */
	public void setLeggings(java.lang.String value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>Account.npcs.leggings</code>.
	 */
	public java.lang.String getLeggings() {
		return (java.lang.String) getValue(13);
	}

	/**
	 * Setter for <code>Account.npcs.boots</code>.
	 */
	public void setBoots(java.lang.String value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>Account.npcs.boots</code>.
	 */
	public java.lang.String getBoots() {
		return (java.lang.String) getValue(14);
	}

	/**
	 * Setter for <code>Account.npcs.inHand</code>.
	 */
	public void setInHand(java.lang.String value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>Account.npcs.inHand</code>.
	 */
	public java.lang.String getInHand() {
		return (java.lang.String) getValue(15);
	}

	/**
	 * Setter for <code>Account.npcs.info</code>.
	 */
	public void setInfo(java.lang.String value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>Account.npcs.info</code>.
	 */
	public java.lang.String getInfo() {
		return (java.lang.String) getValue(16);
	}

	/**
	 * Setter for <code>Account.npcs.infoRadius</code>.
	 */
	public void setInfoRadius(java.lang.Double value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>Account.npcs.infoRadius</code>.
	 */
	public java.lang.Double getInfoRadius() {
		return (java.lang.Double) getValue(17);
	}

	/**
	 * Setter for <code>Account.npcs.infoDelay</code>.
	 */
	public void setInfoDelay(java.lang.Integer value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>Account.npcs.infoDelay</code>.
	 */
	public java.lang.Integer getInfoDelay() {
		return (java.lang.Integer) getValue(18);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record19 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row19<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row19) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row19<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Integer> valuesRow() {
		return (org.jooq.Row19) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return mineplex.database.tables.Npcs.npcs.id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return mineplex.database.tables.Npcs.npcs.server;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return mineplex.database.tables.Npcs.npcs.name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return mineplex.database.tables.Npcs.npcs.world;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field5() {
		return mineplex.database.tables.Npcs.npcs.x;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field6() {
		return mineplex.database.tables.Npcs.npcs.y;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field7() {
		return mineplex.database.tables.Npcs.npcs.z;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field8() {
		return mineplex.database.tables.Npcs.npcs.radius;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field9() {
		return mineplex.database.tables.Npcs.npcs.entityType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field10() {
		return mineplex.database.tables.Npcs.npcs.entityMeta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field11() {
		return mineplex.database.tables.Npcs.npcs.adult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field12() {
		return mineplex.database.tables.Npcs.npcs.helmet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field13() {
		return mineplex.database.tables.Npcs.npcs.chestplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field14() {
		return mineplex.database.tables.Npcs.npcs.leggings;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field15() {
		return mineplex.database.tables.Npcs.npcs.boots;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field16() {
		return mineplex.database.tables.Npcs.npcs.inHand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field17() {
		return mineplex.database.tables.Npcs.npcs.info;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field18() {
		return mineplex.database.tables.Npcs.npcs.infoRadius;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field19() {
		return mineplex.database.tables.Npcs.npcs.infoDelay;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getServer();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getWorld();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value5() {
		return getX();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value6() {
		return getY();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value7() {
		return getZ();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value8() {
		return getRadius();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value9() {
		return getEntityType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value10() {
		return getEntityMeta();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value11() {
		return getAdult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value12() {
		return getHelmet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value13() {
		return getChestplate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value14() {
		return getLeggings();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value15() {
		return getBoots();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value16() {
		return getInHand();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value17() {
		return getInfo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value18() {
		return getInfoRadius();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value19() {
		return getInfoDelay();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value2(java.lang.String value) {
		setServer(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value3(java.lang.String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value4(java.lang.String value) {
		setWorld(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value5(java.lang.Double value) {
		setX(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value6(java.lang.Double value) {
		setY(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value7(java.lang.Double value) {
		setZ(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value8(java.lang.Double value) {
		setRadius(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value9(java.lang.String value) {
		setEntityType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value10(java.lang.String value) {
		setEntityMeta(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value11(java.lang.Boolean value) {
		setAdult(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value12(java.lang.String value) {
		setHelmet(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value13(java.lang.String value) {
		setChestplate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value14(java.lang.String value) {
		setLeggings(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value15(java.lang.String value) {
		setBoots(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value16(java.lang.String value) {
		setInHand(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value17(java.lang.String value) {
		setInfo(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value18(java.lang.Double value) {
		setInfoRadius(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord value19(java.lang.Integer value) {
		setInfoDelay(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NpcsRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, java.lang.Double value5, java.lang.Double value6, java.lang.Double value7, java.lang.Double value8, java.lang.String value9, java.lang.String value10, java.lang.Boolean value11, java.lang.String value12, java.lang.String value13, java.lang.String value14, java.lang.String value15, java.lang.String value16, java.lang.String value17, java.lang.Double value18, java.lang.Integer value19) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached NpcsRecord
	 */
	public NpcsRecord() {
		super(mineplex.database.tables.Npcs.npcs);
	}

	/**
	 * Create a detached, initialised NpcsRecord
	 */
	public NpcsRecord(java.lang.Integer id, java.lang.String server, java.lang.String name, java.lang.String world, java.lang.Double x, java.lang.Double y, java.lang.Double z, java.lang.Double radius, java.lang.String entityType, java.lang.String entityMeta, java.lang.Boolean adult, java.lang.String helmet, java.lang.String chestplate, java.lang.String leggings, java.lang.String boots, java.lang.String inHand, java.lang.String info, java.lang.Double infoRadius, java.lang.Integer infoDelay) {
		super(mineplex.database.tables.Npcs.npcs);

		setValue(0, id);
		setValue(1, server);
		setValue(2, name);
		setValue(3, world);
		setValue(4, x);
		setValue(5, y);
		setValue(6, z);
		setValue(7, radius);
		setValue(8, entityType);
		setValue(9, entityMeta);
		setValue(10, adult);
		setValue(11, helmet);
		setValue(12, chestplate);
		setValue(13, leggings);
		setValue(14, boots);
		setValue(15, inHand);
		setValue(16, info);
		setValue(17, infoRadius);
		setValue(18, infoDelay);
	}
}
