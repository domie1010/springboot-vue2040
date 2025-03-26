<template>
	<div class="addEdit-block" :style='{"minHeight":"calc(100vh - 200px)","padding":"20px 0 30px","margin":"0 auto","color":"#666","background":"none","width":"calc(100% - 60px)","fontSize":"16px","height":"100%"}'>
		<el-form
			:style='{"border":"1px solid #ceddee","padding":"30px 0","boxShadow":"inset 0px 0px 0px 0px #E8EFF7,0 0px 0px 0px rgba(100,100,100,.1)","borderColor":"#eee","alignItems":"flex-start","borderRadius":"8px","flexWrap":"wrap","background":"rgba(255,255,255,.6)","borderWidth":"1px","display":"flex","fontSize":"inherit","borderStyle":"double"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="200px"
		>
			<template >
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="公交编号" prop="gongjiaobianhao">
					<el-input v-model="ruleForm.gongjiaobianhao" placeholder="公交编号" clearable  :readonly="ro.gongjiaobianhao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="公交编号" prop="gongjiaobianhao">
					<el-input v-model="ruleForm.gongjiaobianhao" placeholder="公交编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="公交班次" prop="gongjiaobanci">
					<el-input v-model="ruleForm.gongjiaobanci" placeholder="公交班次" clearable  :readonly="ro.gongjiaobanci"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="公交班次" prop="gongjiaobanci">
					<el-input v-model="ruleForm.gongjiaobanci" placeholder="公交班次" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="起点站" prop="qidianzhan">
					<el-input v-model="ruleForm.qidianzhan" placeholder="起点站" clearable  :readonly="ro.qidianzhan"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="起点站" prop="qidianzhan">
					<el-input v-model="ruleForm.qidianzhan" placeholder="起点站" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="select" v-if="type!='info'"  label="公交线路" prop="gongjiaoxianlu">
					<el-select :disabled="ro.gongjiaoxianlu" v-model="ruleForm.gongjiaoxianlu" placeholder="请选择公交线路" >
						<el-option
							v-for="(item,index) in gongjiaoxianluOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="公交线路" prop="gongjiaoxianlu">
					<el-input v-model="ruleForm.gongjiaoxianlu"
						placeholder="公交线路" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="终点站" prop="zhongdianzhan">
					<el-input v-model="ruleForm.zhongdianzhan" placeholder="终点站" clearable  :readonly="ro.zhongdianzhan"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="终点站" prop="zhongdianzhan">
					<el-input v-model="ruleForm.zhongdianzhan" placeholder="终点站" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian">
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian">
					<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="途经站点" prop="tujingzhandian">
					<el-input v-model="ruleForm.tujingzhandian" placeholder="途经站点" clearable  :readonly="ro.tujingzhandian"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="途经站点" prop="tujingzhandian">
					<el-input v-model="ruleForm.tujingzhandian" placeholder="途经站点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="date" v-if="type!='info'" label="首班车时间" prop="shoubancheshijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.shoubancheshijian" 
						type="datetime"
						:readonly="ro.shoubancheshijian"
						placeholder="首班车时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-else-if="ruleForm.shoubancheshijian" label="首班车时间" prop="shoubancheshijian">
					<el-input v-model="ruleForm.shoubancheshijian" placeholder="首班车时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="date" v-if="type!='info'" label="末班车时间" prop="mobancheshijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.mobancheshijian" 
						type="datetime"
						:readonly="ro.mobancheshijian"
						placeholder="末班车时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-else-if="ruleForm.mobancheshijian" label="末班车时间" prop="mobancheshijian">
					<el-input v-model="ruleForm.mobancheshijian" placeholder="末班车时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="发车间隔" prop="fachejiange">
					<el-input v-model="ruleForm.fachejiange" placeholder="发车间隔" clearable  :readonly="ro.fachejiange"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="发车间隔" prop="fachejiange">
					<el-input v-model="ruleForm.fachejiange" placeholder="发车间隔" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="票价" prop="piaojia">
					<el-input v-model.number="ruleForm.piaojia" placeholder="票价" clearable  :readonly="ro.piaojia"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="票价" prop="piaojia">
					<el-input v-model="ruleForm.piaojia" placeholder="票价" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' class="textarea" v-if="type!='info'" label="详情" prop="xiangqing">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="详情"
					  v-model="ruleForm.xiangqing" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-else-if="ruleForm.xiangqing" label="详情" prop="xiangqing">
					<span :style='{"fontSize":"16px","lineHeight":"40px","color":"inherit","fontWeight":"500","display":"inline-block"}'>{{ruleForm.xiangqing}}</span>
				</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"30px auto","alignItems":"center","textAlign":"center","background":"none","display":"flex","width":"60%","fontSize":"18px"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
					确定
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
					撤消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				gongjiaobianhao : false,
				gongjiaobanci : false,
				qidianzhan : false,
				gongjiaoxianlu : false,
				zhongdianzhan : false,
				tupian : false,
				tujingzhandian : false,
				shoubancheshijian : false,
				mobancheshijian : false,
				fachejiange : false,
				piaojia : false,
				xiangqing : false,
				storeupnum : false,
			},
			
			
			ruleForm: {
				gongjiaobianhao: '',
				gongjiaobanci: '',
				qidianzhan: '',
				gongjiaoxianlu: '',
				zhongdianzhan: '',
				tupian: '',
				tujingzhandian: '',
				shoubancheshijian: '',
				mobancheshijian: '',
				fachejiange: '',
				piaojia: '',
				xiangqing: '',
			},
		
			gongjiaoxianluOptions: [],

			
			rules: {
				gongjiaobianhao: [
				],
				gongjiaobanci: [
				],
				qidianzhan: [
				],
				gongjiaoxianlu: [
				],
				zhongdianzhan: [
				],
				tupian: [
				],
				tujingzhandian: [
				],
				shoubancheshijian: [
				],
				mobancheshijian: [
				],
				fachejiange: [
				],
				piaojia: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				xiangqing: [
				],
				storeupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.shoubancheshijian = this.getCurDateTime()
		this.ruleForm.mobancheshijian = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='gongjiaobianhao'){
							this.ruleForm.gongjiaobianhao = obj[o];
							this.ro.gongjiaobianhao = true;
							continue;
						}
						if(o=='gongjiaobanci'){
							this.ruleForm.gongjiaobanci = obj[o];
							this.ro.gongjiaobanci = true;
							continue;
						}
						if(o=='qidianzhan'){
							this.ruleForm.qidianzhan = obj[o];
							this.ro.qidianzhan = true;
							continue;
						}
						if(o=='gongjiaoxianlu'){
							this.ruleForm.gongjiaoxianlu = obj[o];
							this.ro.gongjiaoxianlu = true;
							continue;
						}
						if(o=='zhongdianzhan'){
							this.ruleForm.zhongdianzhan = obj[o];
							this.ro.zhongdianzhan = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o];
							this.ro.tupian = true;
							continue;
						}
						if(o=='tujingzhandian'){
							this.ruleForm.tujingzhandian = obj[o];
							this.ro.tujingzhandian = true;
							continue;
						}
						if(o=='shoubancheshijian'){
							this.ruleForm.shoubancheshijian = obj[o];
							this.ro.shoubancheshijian = true;
							continue;
						}
						if(o=='mobancheshijian'){
							this.ruleForm.mobancheshijian = obj[o];
							this.ro.mobancheshijian = true;
							continue;
						}
						if(o=='fachejiange'){
							this.ruleForm.fachejiange = obj[o];
							this.ro.fachejiange = true;
							continue;
						}
						if(o=='piaojia'){
							this.ruleForm.piaojia = obj[o];
							this.ro.piaojia = true;
							continue;
						}
						if(o=='xiangqing'){
							this.ruleForm.xiangqing = obj[o];
							this.ro.xiangqing = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
				}
				













			}
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/xianlu/xianlu`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.gongjiaoxianluOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `gongjiaoxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {






	if(this.ruleForm.tupian!=null) {
		this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
	}








var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "gongjiaoxinxi/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `gongjiaoxinxi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.gongjiaoxinxiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `gongjiaoxinxi/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.gongjiaoxinxiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.gongjiaoxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    tupianUploadChange(fileUrls) {
	    this.ruleForm.tupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: inherit;
	  	  background: none;
	  	  font-weight: 600;
	  	  display: inline-block;
	  	  width: 200px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 200px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  padding: 0 30px;
	  	  color: inherit;
	  	  font-size: 16px;
	  	  border-color: #b4b4b4;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(98% 0, 100% 51%, 98% 100%, 2% 100%, 0% 50%, 2% 0);
	  	  background: #eee;
	  	  width: 400px;
	  	  border-width: 0px;
	  	  border-style: solid;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  padding: 0 30px;
	  	  color: inherit;
	  	  font-size: 16px;
	  	  border-color: #b4b4b4;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(98% 0, 100% 51%, 98% 100%, 2% 100%, 0% 50%, 2% 0);
	  	  background: #eee;
	  	  width: 400px;
	  	  border-width: 0px;
	  	  border-style: solid;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  padding: 0 30px;
	  	  color: inherit;
	  	  font-size: 16px;
	  	  border-color: #C7D5E0;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(98% 0, 100% 51%, 98% 100%, 2% 100%, 0% 50%, 2% 0);
	  	  background: #eee;
	  	  width: auto;
	  	  border-width: 0px;
	  	  border-style: solid;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  padding: 0 30px;
	  	  color: inherit;
	  	  font-size: 16px;
	  	  border-color: #C7D5E0;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(98% 0, 100% 51%, 98% 100%, 2% 100%, 0% 50%, 2% 0);
	  	  background: #eee;
	  	  width: auto;
	  	  border-width: 0 0 0px;
	  	  border-style: solid;
	  	  min-width: 250px;
	  	  height: 36px;
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
	  	  border: 0px solid #C7D5E0;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  clip-path: polygon(90% 0, 100% 51%, 90% 100%, 10% 100%, 0% 50%, 10% 0);
	  	  color: #aaa;
	  	  background: #eee;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 0px solid #C7D5E0;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  clip-path: polygon(90% 0, 100% 51%, 90% 100%, 10% 100%, 0% 50%, 10% 0);
	  	  color: #aaa;
	  	  background: #eee;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 0px solid #C7D5E0;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  clip-path: polygon(90% 0, 100% 51%, 90% 100%, 10% 100%, 0% 50%, 10% 0);
	  	  color: #aaa;
	  	  background: #eee;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 0px solid #C7D5E0;
	  	  border-radius: 4px;
	  	  padding: 10px 36px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(95% 0, 100% 51%, 95% 100%, 5% 100%, 0% 50%, 5% 0);
	  	  color: inherit;
	  	  background: #eee;
	  	  width: 500px;
	  	  font-size: 16px;
	  	  height: 140px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0px solid #3fcbca;
				cursor: pointer;
				padding: 0 10px;
				margin: 0px 4px;
				color: #fff;
				display: inline-block;
				font-size: 18px;
				line-height: 24px;
				border-radius: 10px;
				outline: none;
				clip-path: polygon(5% 0, 100% 0%, 95% 100%, 0% 100%);
				background: #5680ac;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0px solid #23b7e5;
				cursor: pointer;
				padding: 0 10px;
				margin: 0px 4px;
				color: #fff;
				font-size: 18px;
				line-height: 24px;
				border-radius: 10px;
				outline: none;
				clip-path: polygon(5% 0, 100% 0%, 95% 100%, 0% 100%);
				background: #56ac92;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0px solid #3fcbca;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 4px;
				color: #fff;
				font-size: 18px;
				line-height: 24px;
				border-radius: 10px;
				outline: none;
				clip-path: polygon(5% 0, 100% 0%, 95% 100%, 0% 100%);
				background: #64ac56;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0px solid #FF6B6B;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 4px;
				color: #fff;
				font-size: 18px;
				line-height: 24px;
				border-radius: 10px;
				outline: none;
				clip-path: polygon(5% 0, 100% 0%, 95% 100%, 0% 100%);
				background: #be696d;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0px solid #65C3DF;
				cursor: pointer;
				padding: 0 20px;
				margin: 4px;
				color: #fff;
				font-size: 18px;
				line-height: 24px;
				border-radius: 10px;
				outline: none;
				clip-path: polygon(5% 0, 100% 0%, 95% 100%, 0% 100%);
				background: #aaa;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
