package com.winning.isc.service;

import java.util.List;
import java.util.Set;

import com.winning.isc.model.SysModPopedom;


/**
* @author HLHT
* @title SYS_MOD_POPEDOM
* @email Winning Health
* @package com.winning.isc.service
* @date 2018-47-02 09:47:09
*/
public interface SysModPopedomService {

    public int createSysModPopedom(SysModPopedom sysModPopedom);

    public int modifySysModPopedom(SysModPopedom sysModPopedom);

    public int removeSysModPopedom(SysModPopedom sysModPopedom);

    public SysModPopedom getSysModPopedom(SysModPopedom sysModPopedom);

    public int getSysModPopedomCount(SysModPopedom sysModPopedom);

    public List<SysModPopedom> getSysModPopedomList(SysModPopedom sysModPopedom);

    public List<SysModPopedom> getSysModPopedomPageList(SysModPopedom sysModPopedom);

    Set<String> getButtonFlagForPageByModUrlAndRoles(SysModPopedom modPopedom);

    List<Long> getModuleIdList(SysModPopedom modPopedom);

    void createSysModPopedomByList(List<SysModPopedom> modPopedomList);

    void modifyModPopedomMapping(String idList);

    List<SysModPopedom> getSysModPopedomHasPopedomList(SysModPopedom modPopedom);
}