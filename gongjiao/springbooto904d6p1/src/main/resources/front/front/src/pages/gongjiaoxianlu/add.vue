<template>
<div :style='{"width":"80%","padding":"20px","margin":"10px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"width":"100%","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="100px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="公交车号" prop="gongjiaochehao">
            <el-input v-model="ruleForm.gongjiaochehao" 
                placeholder="公交车号" clearable :disabled=" false  ||ro.gongjiaochehao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="路线图片" v-if="type!='cross' || (type=='cross' && !ro.luxiantupian)" prop="luxiantupian">
            <file-upload
            tip="点击上传路线图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.luxiantupian?ruleForm.luxiantupian:''"
            @change="luxiantupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' class="upload" v-else label="路线图片" prop="luxiantupian">
                <img v-if="ruleForm.luxiantupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.luxiantupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.luxiantupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'  label="车次" prop="checi">
            <el-select v-model="ruleForm.checi" placeholder="请选择车次" :disabled=" false  ||ro.checi" >
              <el-option
                  v-for="(item,index) in checiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'  label="线路" prop="xianlu">
            <el-select v-model="ruleForm.xianlu" placeholder="请选择线路" :disabled=" false  ||ro.xianlu" >
              <el-option
                  v-for="(item,index) in xianluOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="始发站点" prop="shifazhandian">
            <el-input v-model="ruleForm.shifazhandian" 
                placeholder="始发站点" clearable :disabled=" false  ||ro.shifazhandian"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="票价" prop="piaojia">
            <el-input v-model="ruleForm.piaojia" 
                placeholder="票价" clearable :disabled=" false  ||ro.piaojia"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="终点站点" prop="zhongdianzhandian">
            <el-input v-model="ruleForm.zhongdianzhandian" 
                placeholder="终点站点" clearable :disabled=" false  ||ro.zhongdianzhandian"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="运行时间" prop="yunxingshijian">
            <el-input v-model="ruleForm.yunxingshijian" 
                placeholder="运行时间" clearable :disabled=" false  ||ro.yunxingshijian"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="更新时间" prop="gengxinshijian">
              <el-date-picker
				  :disabled=" false  ||ro.gengxinshijian"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.gengxinshijian" 
                  type="date"
                  placeholder="更新时间">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="途径站点" prop="tujingzhandian">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="途径站点"
              v-model="ruleForm.tujingzhandian">
            </el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="换乘信息" prop="huanchengxinxi">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="换乘信息"
              v-model="ruleForm.huanchengxinxi">
            </el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="路线详情" prop="luxianxiangqing">
            <editor 
                :style='{"padding":"0","boxShadow":"none","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.luxianxiangqing" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"5px","background":"#57A7A5","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"none","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(64, 158, 255, 1)","borderRadius":"5px","background":"#9E9E9E","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				gongjiaochehao : false,
				luxiantupian : false,
				checi : false,
				xianlu : false,
				shifazhandian : false,
				piaojia : false,
				tujingzhandian : false,
				zhongdianzhandian : false,
				huanchengxinxi : false,
				yunxingshijian : false,
				luxianxiangqing : false,
				gengxinshijian : false,
				clicktime : false,
				clicknum : false,
				discussnum : false,
				storeupnum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          gongjiaochehao: '',
          luxiantupian: '',
          checi: '',
          xianlu: '',
          shifazhandian: '',
          piaojia: '',
          tujingzhandian: '',
          zhongdianzhandian: '',
          huanchengxinxi: '',
          yunxingshijian: '',
          luxianxiangqing: '',
          gengxinshijian: '',
          clicktime: '',
          clicknum: '',
          discussnum: '',
          storeupnum: '',
        },
        checiOptions: [],
        xianluOptions: [],


        rules: {
          gongjiaochehao: [
          ],
          luxiantupian: [
          ],
          checi: [
          ],
          xianlu: [
          ],
          shifazhandian: [
          ],
          piaojia: [
          ],
          tujingzhandian: [
          ],
          zhongdianzhandian: [
          ],
          huanchengxinxi: [
          ],
          yunxingshijian: [
          ],
          luxianxiangqing: [
          ],
          gengxinshijian: [
          ],
          clicktime: [
          ],
          clicknum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          discussnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          storeupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.gengxinshijian = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='gongjiaochehao'){
              this.ruleForm.gongjiaochehao = obj[o];
              this.ro.gongjiaochehao = true;
              continue;
            }
            if(o=='luxiantupian'){
              this.ruleForm.luxiantupian = obj[o].split(",")[0];
              this.ro.luxiantupian = true;
              continue;
            }
            if(o=='checi'){
              this.ruleForm.checi = obj[o];
              this.ro.checi = true;
              continue;
            }
            if(o=='xianlu'){
              this.ruleForm.xianlu = obj[o];
              this.ro.xianlu = true;
              continue;
            }
            if(o=='shifazhandian'){
              this.ruleForm.shifazhandian = obj[o];
              this.ro.shifazhandian = true;
              continue;
            }
            if(o=='piaojia'){
              this.ruleForm.piaojia = obj[o];
              this.ro.piaojia = true;
              continue;
            }
            if(o=='tujingzhandian'){
              this.ruleForm.tujingzhandian = obj[o];
              this.ro.tujingzhandian = true;
              continue;
            }
            if(o=='zhongdianzhandian'){
              this.ruleForm.zhongdianzhandian = obj[o];
              this.ro.zhongdianzhandian = true;
              continue;
            }
            if(o=='huanchengxinxi'){
              this.ruleForm.huanchengxinxi = obj[o];
              this.ro.huanchengxinxi = true;
              continue;
            }
            if(o=='yunxingshijian'){
              this.ruleForm.yunxingshijian = obj[o];
              this.ro.yunxingshijian = true;
              continue;
            }
            if(o=='luxianxiangqing'){
              this.ruleForm.luxianxiangqing = obj[o];
              this.ro.luxianxiangqing = true;
              continue;
            }
            if(o=='gengxinshijian'){
              this.ruleForm.gengxinshijian = obj[o];
              this.ro.gengxinshijian = true;
              continue;
            }
            if(o=='clicktime'){
              this.ruleForm.clicktime = obj[o];
              this.ro.clicktime = true;
              continue;
            }
            if(o=='clicknum'){
              this.ruleForm.clicknum = obj[o];
              this.ro.clicknum = true;
              continue;
            }
            if(o=='discussnum'){
              this.ruleForm.discussnum = obj[o];
              this.ro.discussnum = true;
              continue;
            }
            if(o=='storeupnum'){
              this.ruleForm.storeupnum = obj[o];
              this.ro.storeupnum = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/checi/checi', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.checiOptions = res.data.data;
          }
        });
        this.$http.get('option/xianlu/xianlu', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.xianluOptions = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`gongjiaoxianlu/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('gongjiaoxianlu/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`gongjiaoxianlu/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`gongjiaoxianlu/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
      luxiantupianUploadChange(fileUrls) {
          this.ruleForm.luxiantupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #000;
	  font-weight: 500;
	  width: 100px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 100px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 10px 0 30px;
	  box-shadow: none;
	  outline: none;
	  color: none;
	  width: 500px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 0;
	  color: #000;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 0;
	  color: #000;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 0;
	  color: #000;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
