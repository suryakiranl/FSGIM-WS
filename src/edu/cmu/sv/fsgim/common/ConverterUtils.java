package edu.cmu.sv.fsgim.common;

import com.google.appengine.api.datastore.Text;

import edu.cmu.sv.fsgim.business.dto.BaseDTO;
import edu.cmu.sv.fsgim.business.dto.Query;
import edu.cmu.sv.fsgim.data.po.BasePO;
import edu.cmu.sv.fsgim.data.po.QueryPO;

public class ConverterUtils {
	public static final QueryPO convert(Query dto) {
		if (dto == null)
			return null;

		QueryPO po = new QueryPO();
		po.setQueryClassification(dto.getQueryClassification());
		po.setQueryName(dto.getQueryName());
		po.setQueryString(new Text(dto.getQueryString()));
		po.setModelName(dto.getModelName());
		po.setModelVersion(dto.getModelVersion());

		updateWhoColumns(dto, po);

		return po;
	}

	public static final Query convert(QueryPO po) {
		if (po == null)
			return null;

		Query dto = new Query();
		dto.setQueryClassification(po.getQueryClassification());
		dto.setQueryName(po.getQueryName());
		dto.setQueryString(po.getQueryString().getValue());
		dto.setModelName(po.getModelName());
		dto.setModelVersion(po.getModelVersion());

		updateWhoColumns(po, dto);

		return dto;
	}

	public static final void updateWhoColumns(BasePO source, BaseDTO dest) {
		if (source.getId() != null)
			dest.setId(source.getId());
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}

	public static final void updateWhoColumns(BaseDTO source, BasePO dest) {
		if (source.getId() != 0)
			dest.setId(source.getId());
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}
}